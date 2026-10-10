import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

// ANSI Color Codes for enhanced terminal output
class Colors {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String WHITE = "\u001B[37m";
    public static final String BRIGHT_WHITE = "\u001B[97m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
}

// Class representing a process that implements Runnable to be run by a thread
class Process implements Runnable {
    private String name; // Name of the process
    private int burstTime; // Total time the process requires to complete (in milliseconds)
    private int timeQuantum; // Time slice (time quantum) allowed per CPU access (in milliseconds)
    private int remainingTime; // Time left for the process to finish its execution

    // Feature1: add priority field (integer 1-10, where 10 is highest)
    private int priority; // Priority of the process (1-10, 10 being highest)
   
    // Feature3: Fields to track waiting time
    private long creationTime; // Timestamp when the process object was created
    private long queueEntryTime; // Timestamp when the process entered the ready queue
    private long totalWaitingTime; // Total time the process spent waiting for CPU access
    private long lastReadyTime; // Timestamp when process re-entered the ready queue

    // Constructor to initialize the process with name, burst time, time quantum, and priority
    public Process(String name, int burstTime, int timeQuantum, int priority) {
        this.name = name;
        this.burstTime = burstTime;
        this.timeQuantum = timeQuantum;
        this.priority = priority;
        this.remainingTime = burstTime;
        
        // Feature3: Initialize timing fields
        this.creationTime = System.currentTimeMillis();
        this.queueEntryTime = this.creationTime;
        this.lastReadyTime = this.creationTime;
    }

    // Default constructor keeps compatibility with existing code while assigning a random priority
    public Process(String name, int burstTime, int timeQuantum) {
        this(name, burstTime, timeQuantum, 1 + new Random().nextInt(10));
    }

    // This method will be called when the thread for this process is started
    @Override
    public void run() {
        // Simulate running for either the time quantum or remaining time, whichever is smaller
        int runTime = Math.min(timeQuantum, remainingTime); // Run for the smaller of the two times
        
        // Show quantum execution starting
        String quantumBar = createProgressBar(0, 15);
        System.out.println(Colors.BRIGHT_GREEN + "  ▶️ " + Colors.BOLD + Colors.CYAN + name + 
                          Colors.RESET + Colors.GREEN + " executing quantum" + Colors.RESET + 
                          " [" + runTime + "ms] ");
        
        try {
            // Simulate quantum execution with progress updates
            int steps = 5; // Number of progress updates
            int stepTime = runTime / steps;
            
            for (int i = 1; i <= steps; i++) {
                Thread.sleep(stepTime);
                int quantumProgress = (i * 100) / steps;
                quantumBar = createProgressBar(quantumProgress, 15);
                
                // Clear line and show updated progress
                System.out.print("\r  " + Colors.YELLOW + "⚡" + Colors.RESET + 
                                " Quantum progress: " + quantumBar);
            }
            System.out.println(); // New line after quantum completion
            
        } catch (InterruptedException e) {
            System.out.println(Colors.RED + "\n  ✗ " + name + " was interrupted." + Colors.RESET);
        }
        
        remainingTime -= runTime; // Deduct the run time from the remaining time
        int overallProgress = (int) (((double)(burstTime - remainingTime) / burstTime) * 100);
        String overallProgressBar = createProgressBar(overallProgress, 20);
        
        System.out.println(Colors.YELLOW + "  ⏸ " + Colors.CYAN + name + Colors.RESET + 
                          " completed quantum " + Colors.BRIGHT_YELLOW + runTime + "ms" + Colors.RESET + 
                          " │ Overall progress: " + overallProgressBar);
        System.out.println(Colors.MAGENTA + "     Remaining time: " + remainingTime + "ms" + Colors.RESET);
        
        // If the process still has remaining time, it yields CPU for the next process
        if (remainingTime > 0) {
            System.out.println(Colors.BLUE + "  ↻ " + Colors.CYAN + name + Colors.RESET + 
                              " yields CPU for context switch" + Colors.RESET);
        } else {
            // If no time is left, the process has finished its execution
            System.out.println(Colors.BRIGHT_GREEN + "  ✓ " + Colors.BOLD + Colors.CYAN + name + 
                              Colors.RESET + Colors.BRIGHT_GREEN + " finished execution!" + 
                              Colors.RESET);
        }
        System.out.println();
    }
    
    // Helper method to create a visual progress bar
    private String createProgressBar(int progress, int width) {
        int filled = (progress * width) / 100;
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < width; i++) {
            if (i < filled) {
                bar.append(Colors.GREEN + "█" + Colors.RESET);
            } else {
                bar.append(Colors.WHITE + "░" + Colors.RESET);
            }
        }
        bar.append("] ").append(progress).append("%");
        return bar.toString();
    }

    // Method to run the last process to completion, ignoring the time quantum
    public void runToCompletion() {
        try {
            System.out.println(Colors.BRIGHT_CYAN + "  ⚡ " + Colors.BOLD + Colors.CYAN + name + 
                              Colors.RESET + Colors.BRIGHT_CYAN + " is the last process, running to completion" + 
                              Colors.RESET + " [" + remainingTime + "ms]");
            Thread.sleep(remainingTime); // Run until completion
            remainingTime = 0; // Mark the process as completed
            System.out.println(Colors.BRIGHT_GREEN + "  ✓ " + Colors.BOLD + Colors.CYAN + name + 
                              Colors.RESET + Colors.BRIGHT_GREEN + " finished execution!" + Colors.RESET);
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println(Colors.RED + "  ✗ " + name + " was interrupted." + Colors.RESET);
        }
    }

    public void recordQueueEntry() {
        this.queueEntryTime = System.currentTimeMillis();
    }

    // Getter methods for process name, burst time, remaining time, and priority
    public String getName() {
        return name;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }
    
    // Feature1: Getter for priority
    public int getPriority() {
        return priority;
    }

    // Feature3: Getter for creation time
    public long getCreationTime() {
        return creationTime;
    }
    
    // Feature3: Getter for total waiting time
    public long getTotalWaitingTime() {
        return totalWaitingTime;
    }
    
    // Feature3: Getter for last ready time
    public long getLastReadyTime() {
        return lastReadyTime;
    }
    
    // Feature3: Method to update waiting time when process is about to run
    public void updateWaitingTime() {
        long currentTime = System.currentTimeMillis();
        long waitTime = currentTime - lastReadyTime; // Time spent waiting since last added to queue
        totalWaitingTime += waitTime;
    }
    
    // Feature3: Method to set last ready time when process re-enters queue
    public void setLastReadyTime(long time) {
        this.lastReadyTime = time;
    }

    // Feature3: Calculate turnaround time = waiting time + burst time
    public long getTurnaroundTime() {
        return totalWaitingTime + burstTime;
    }

    // Check if the process has finished (i.e., no remaining time)
    public boolean isFinished() {
        return remainingTime <= 0;
    }
}

public class SchedulerSimulation {
    // Feature2: Static counter for context switches
    private static int contextSwitchCount = 0;

    // Feature3: List to store all completed processes for summary
    private static List<Process> completedProcesses = new ArrayList<>();

    public static void main(String[] args) {
        // ⚠️ IMPORTANT: Put your student ID here to seed the random number generator
        int studentID = 445052059;  // ← CHANGE THIS TO YOUR ACTUAL STUDENT ID
        
        Random random = new Random(studentID);
        
        int timeQuantum = 2000 + random.nextInt(4) * 1000; // Random: 2000, 3000, 4000, or 5000
        int numProcesses = 10 + random.nextInt(11); // Random number between 10 and 20
        
        Queue<Thread> processQueue = new LinkedList<>();
        Map<Thread, Process> processMap = new HashMap<>();

        // Print simulation header
        System.out.println("\n" + Colors.BOLD + Colors.BRIGHT_CYAN + 
                          "╔═══════════════════════════════════════════════════════════════════════════════════════╗" + 
                          Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET + 
                          Colors.BG_BLUE + Colors.BRIGHT_WHITE + Colors.BOLD + 
                          "                          CPU SCHEDULER SIMULATION                                " + 
                          Colors.RESET + Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + 
                          "╠═══════════════════════════════════════════════════════════════════════════════════════╣" + 
                          Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET + 
                          Colors.YELLOW + "  ⚙ Processes:     " + Colors.RESET + Colors.BRIGHT_YELLOW + 
                          String.format("%-65s", numProcesses) + 
                          Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET + 
                          Colors.YELLOW + "  ⏱ Time Quantum:  " + Colors.RESET + Colors.BRIGHT_YELLOW + 
                          String.format("%-65s", timeQuantum + "ms") + 
                          Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET + 
                          Colors.YELLOW + "  🔑 Student ID:    " + Colors.RESET + Colors.BRIGHT_YELLOW + 
                          String.format("%-65s", studentID) + 
                          Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + 
                          "╚═══════════════════════════════════════════════════════════════════════════════════════╝" + 
                          Colors.RESET + "\n");
        
        // Create 'numProcesses' number of processes
        for (int i = 1; i <= numProcesses; i++) {
            int burstTime = timeQuantum/2 + random.nextInt(2 * timeQuantum + 1);
            int priority = 1 + random.nextInt(10); 
            Process process = new Process("P" + i, burstTime, timeQuantum, priority);
            
            addProcessToQueue(process, processQueue, processMap);
        }
        
        System.out.println(Colors.BOLD + Colors.GREEN + 
                          "╔════════════════════════════════════════════════════════════════════════════════╗" + 
                          Colors.RESET);
        System.out.println(Colors.BOLD + Colors.GREEN + "║" + Colors.RESET + 
                          Colors.BG_GREEN + Colors.WHITE + Colors.BOLD + 
                          "                        ▶️  SCHEDULER STARTING  ◀️                               " + 
                          Colors.RESET + Colors.BOLD + Colors.GREEN + "║" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.GREEN + 
                          "╚════════════════════════════════════════════════════════════════════════════════╝" + 
                          Colors.RESET + "\n");
        
        // Loop to manage the scheduling of processes
        while (!processQueue.isEmpty()) {
            Thread currentThread = processQueue.poll();

            // Feature2: increment context switch counter
            contextSwitchCount++;
            
            Process process = processMap.get(currentThread);
 
            // Feature3: Update waiting time for this process before it runs
            process.updateWaitingTime();
            
            // Print the current process queue
            System.out.println(Colors.BOLD + Colors.MAGENTA + "┌─ Ready Queue " + "─".repeat(65) + Colors.RESET);
            System.out.print(Colors.MAGENTA + "│ " + Colors.RESET + Colors.BRIGHT_WHITE + "[" + Colors.RESET);
            int queueCount = 0;
            for (Thread thread : processQueue) {
                Process queuedProcess = processMap.get(thread);
                if (queueCount > 0) System.out.print(Colors.WHITE + " → " + Colors.RESET);
                System.out.print(Colors.BRIGHT_CYAN + queuedProcess.getName() + Colors.RESET);
                queueCount++;
            }
            if (queueCount == 0) {
                System.out.print(Colors.YELLOW + "empty" + Colors.RESET);
            }
            System.out.println(Colors.BRIGHT_WHITE + "]" + Colors.RESET);
            System.out.println(Colors.BOLD + Colors.MAGENTA + "└" + "─".repeat(79) + Colors.RESET + "\n");
            
            System.out.println(Colors.BRIGHT_YELLOW + "  ▶️ " + Colors.BOLD + Colors.CYAN + process.getName() +
                              Colors.RESET + Colors.BRIGHT_YELLOW + " (Priority: " + process.getPriority() + ")" +
                              Colors.RESET + " starts running");
            currentThread.start();
            
            try {
                currentThread.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
            
            if (!process.isFinished()) {
                if (!processQueue.isEmpty()) {
                    // Feature3: Set last ready time when re-entering queue
                    process.setLastReadyTime(System.currentTimeMillis());
                    addProcessToQueue(process, processQueue, processMap);
                } else {
                    System.out.println(Colors.BRIGHT_YELLOW + "  ⚠ " + Colors.CYAN + process.getName() + 
                                      Colors.RESET + Colors.YELLOW + " is the last process → running to completion" + 
                                      Colors.RESET);
                    process.runToCompletion();
                    completedProcesses.add(process);
                }
            } else {
                completedProcesses.add(process);
            }
        }
        
        System.out.println(Colors.BOLD + Colors.BRIGHT_GREEN + 
                          "╔════════════════════════════════════════════════════════════════════════════════╗" + 
                          Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_GREEN + "║" + Colors.RESET + 
                          Colors.BG_GREEN + Colors.WHITE + Colors.BOLD + 
                          "                     ✓  ALL PROCESSES COMPLETED  ✓                            " + 
                          Colors.RESET + Colors.BOLD + Colors.BRIGHT_GREEN + "║" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_GREEN + 
                          "╚════════════════════════════════════════════════════════════════════════════════╝" + 
                          Colors.RESET + "\n");

        // Feature2: Display total context switches
        System.out.println(Colors.BOLD + Colors.BRIGHT_YELLOW + 
                          "╔══════════════════════════════════════════════════════════════════════════════════╗" + 
                          Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_YELLOW + "║" + Colors.RESET + 
                          Colors.BG_BLUE + Colors.BRIGHT_WHITE + Colors.BOLD + 
                          "                        SCHEDULER STATISTICS                                     " + 
                          Colors.RESET + Colors.BOLD + Colors.BRIGHT_YELLOW + "║" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_YELLOW + 
                          "╠══════════════════════════════════════════════════════════════════════════════════╣" + 
                          Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_YELLOW + "║" + Colors.RESET + 
                          Colors.CYAN + "  🔄 Total Context Switches: " + Colors.RESET + 
                          Colors.BRIGHT_CYAN + String.format("%-52s", contextSwitchCount) + 
                          Colors.BOLD + Colors.BRIGHT_YELLOW + "║" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_YELLOW + 
                          "╚══════════════════════════════════════════════════════════════════════════════════╝" + 
                          Colors.RESET + "\n");

        // Feature3: Display waiting time & turnaround time summary table
        displayWaitingTimeSummary();
    }

    public static void addProcessToQueue(Process process, Queue<Thread> processQueue, 
                                        Map<Thread, Process> processMap) {
        Thread thread = new Thread(process);
        process.recordQueueEntry();
        
        processQueue.add(thread);
        processMap.put(thread, process);

        System.out.println(Colors.BLUE + "  ➕ " + Colors.BOLD + Colors.CYAN + process.getName() + 
                          Colors.RESET + Colors.YELLOW + " (Priority: " + process.getPriority() + ")" + 
                          Colors.RESET + Colors.BLUE + " added to ready queue" + Colors.RESET + 
                          " │ Burst time: " + Colors.YELLOW + process.getBurstTime() + "ms" + 
                          Colors.RESET);
    }

    public static void displayWaitingTimeSummary() {
        Collections.sort(completedProcesses, Comparator.comparing(Process::getName));

        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + 
                          "╔══════════════════════════════════════════════════════════════════════════════════╗" + 
                          Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET + 
                          Colors.BG_BLUE + Colors.BRIGHT_WHITE + Colors.BOLD + 
                          "                PROCESS WAITING & TURNAROUND TIME SUMMARY                        " + 
                          Colors.RESET + Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET);
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + 
                          "╠══════════════════════════════════════════════════════════════════════════════════╣" + 
                          Colors.RESET);
        
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET + 
                          "  " + Colors.BOLD + Colors.BRIGHT_WHITE + 
                          String.format("%-10s", "Process") + 
                          String.format("%-12s", "Burst Time") + 
                          String.format("%-10s", "Priority") + 
                          String.format("%-15s", "Waiting Time") + 
                          String.format("%-18s", "Turnaround Time") + 
                          Colors.RESET + "   " +
                          Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET);
        
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + 
                          "╠══════════════════════════════════════════════════════════════════════════════════╣" + 
                          Colors.RESET);
        
        long totalWaitingTime = 0;
        long totalTurnaroundTime = 0;
        
        for (Process process : completedProcesses) {
            long turnaroundTime = process.getTurnaroundTime();
            String waitTimeStr = process.getTotalWaitingTime() + "ms";
            String turnaroundStr = turnaroundTime + "ms";
            
            System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET + 
                              "  " + Colors.BRIGHT_CYAN + 
                              String.format("%-10s", process.getName()) + Colors.RESET +
                              Colors.YELLOW + 
                              String.format("%-12s", process.getBurstTime() + "ms") + Colors.RESET +
                              Colors.MAGENTA + 
                              String.format("%-10s", process.getPriority()) + Colors.RESET +
                              Colors.BRIGHT_GREEN + 
                              String.format("%-15s", waitTimeStr) + Colors.RESET +
                              Colors.BRIGHT_YELLOW + 
                              String.format("%-18s", turnaroundStr) + Colors.RESET +
                              "   " +
                              Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET);
            
            totalWaitingTime += process.getTotalWaitingTime();
            totalTurnaroundTime += turnaroundTime;
        }
        
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + 
                          "╠══════════════════════════════════════════════════════════════════════════════════╣" + 
                          Colors.RESET);
        
        double avgWaitingTime = (double) totalWaitingTime / completedProcesses.size();
        double avgTurnaroundTime = (double) totalTurnaroundTime / completedProcesses.size();
        
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET + 
                          "  " + Colors.BOLD + Colors.BRIGHT_YELLOW + 
                          String.format("%-47s", "Averages:") + 
                          String.format("%-15s", String.format("%.2fms", avgWaitingTime)) + 
                          String.format("%-18s", String.format("%.2fms", avgTurnaroundTime)) + 
                          Colors.RESET + "   " +
                          Colors.BOLD + Colors.BRIGHT_CYAN + "║" + Colors.RESET);
        
        System.out.println(Colors.BOLD + Colors.BRIGHT_CYAN + 
                          "╚══════════════════════════════════════════════════════════════════════════════════╝" + 
                          Colors.RESET + "\n");
    }
}