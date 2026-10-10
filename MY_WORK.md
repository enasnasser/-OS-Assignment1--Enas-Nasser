# 📝 MY_WORK: Student Information, Development Log, Reflection & Answers

> This is the **only file** your instructor reads to grade Parts 3 and 4 (documentation and video). Everything you write here must be **in your own words**.

---

## 🛑 STOP: Read This Before You Do Anything Else

> ### 1️⃣ Read the whole `README.md` first
> The `README.md` in this repository contains the full instructions: class descriptions, feature specifications, question prompts and the video script. **If you skip it, you will lose marks.**
>
> ### 2️⃣ Understand the full code before answering any question
> Open `SchedulerSimulation.java` and read it **from top to bottom**. You must be able to explain what `Process`, `run()`, `runToCompletion()`, `addProcessToQueue()`, `Thread.start()`, `Thread.join()` and `Thread.sleep()` do **before** you write a single answer in Parts B and C. Run the program at least once and watch the output.
>
> ### 3️⃣ Commit many times, not once
> A single commit, or all commits made in the last hour, costs you **-0.5 mark**. See the [Commit Rules](#-commit-rules-mandatory) below.

**How to use this file:**
1. Fill in your **Student Information** (below) right now.
2. Follow the steps in the **Work Roadmap** in order.
3. Update the **Development Log** *every time* you work on the assignment, not at the end.
4. Do not delete any section header. Replace the `[...]` placeholders with your own text.

---

## 👤 Student Information

> ⚠️ **WARNING:** Fill this in first. Your name and ID must match the student ID you set in `SchedulerSimulation.java` (line 150) and the one you say in your video.

| Field | Your Answer |
|-------|-------------|
| **Full Name** | Enas Nasser  |
| **Student ID** | 445052059 |
| **University Email** | 445052059@std.psau.edu.sa |
| **GitHub Username** | enasnasser |
| **Repository Link** | https://github.com/enasnasser/-OS-Assignment1--Enas-Nasser.git |
 
---

## 🎥 Video Link

**Video Link**: [Paste your video link here]

> ⚠️ **WARNING:** The video must be **publicly accessible** ("Anyone with the link can view") on **Google Drive**, **YouTube (Unlisted or Public)** or any other cloud file-sharing system. A private, restricted or broken link counts as a **missing video (-1 mark)**.
>
> 💡 **TIP:** Open the link in a **private/incognito window** before you submit. If it asks you to log in or request access, it is not public.
>
> 📌 **NOTE:** The link goes in **this file only** (`MY_WORK.md`), **not** in `README.md`. Name your video file `StudentID_Assignment1_Demo.mp4`. It must last **2 to 3 minutes**.

---

## 🗺️ Work Roadmap (follow in this order)

| Step | What to do | Where | Marks |
|:----:|------------|-------|:-----:|
| 0 | Read `README.md`, then read and run the full code | Your IDE | – |
| 1 | Fork, rename, keep the repo **PUBLIC**, set your student ID (line 150), **commit** | GitHub + code | Part 1 (1) |
| 2 | Feature 1: Process Priority, **commit** | Code | Part 2 (0.25) |
| 3 | Feature 2: Context Switch Counter, **commit** | Code | Part 2 (0.25) |
| 4 | Feature 3: Waiting Time Tracking, **commit** | Code | Part 2 (0.5) |
| 5 | Development Log (5+ entries, different dates) | This file, Part A | Part 3 (0.5) |
| 6 | Reflection (4 questions) | This file, Part B | Part 3 (0.5) |
| 7 | Technical Answers (4 questions) | This file, Part C | Part 3 (0.5) |
| 8 | Record the video, upload it, paste the link above | Video + this file | Part 4 (1.5) |
| 9 | Final check, then submit the repo link on Blackboard | Blackboard | – |

> 💡 **TIP:** Tick each step off as you go. Do not leave the log, the reflection or the video for the last day.

---

## 🔁 Commit Rules (MANDATORY)

> ### ⚠️ MANY COMMITS ARE REQUIRED. A single bulk commit is penalized (-0.5 mark).

**Minimum: 3 meaningful commits. Aim for 6 or more.**

| # | Commit | Example message |
|:-:|--------|-----------------|
| 1 | Student ID set | `Set my student ID: 441234567` |
| 2 | Feature 1: Priority | `Feature 1: Added priority field to Process class` |
| 3 | Feature 2: Context switches | `Feature 2: Implemented context switch counter` |
| 4 | Feature 3: Waiting time | `Feature 3: Added waiting time tracking and summary table` |
| 5 | Development log entries | `Docs: Added development log entries 1-3` |
| 6 | Reflection and answers | `Docs: Completed reflection and technical answers` |
| 7 | Video link | `Docs: Added demo video link` |

**Rules:**
- ✅ **One commit per feature.** Do not put all three features in one commit.
- ✅ **Commit after each work session**, and after each part of this file.
- ✅ **Spread your commits over different dates.** Not all in one day.
- ❌ **Do not make all commits in the last hour** before the deadline.
- ❌ **No vague messages** like `done`, `update` or `final version`.

> 💡 **TIP:** Your commit history is checked and you **show it in your video** (at least 3 commits visible). Your development log dates should match your commit dates.
>
> 💡 **TIP:** **Use VS Code** (see *Recommended Development Environment* in `README.md` for the full setup). Sign in to GitHub in VS Code, then commit from the Source Control panel (Ctrl+Shift+G) → stage → write a message → Commit → Sync/Push. You can edit and commit this file the same way. **Pushing** matters: commits that are not pushed to GitHub are invisible to the instructor.

---

# Part A: Development Log (0.5 mark)

> ⚠️ **WARNING:** Minimum **5 entries**, spread over **different dates**. Five entries written on the same day, or written all at once at the end, will lose marks and look like a copy. Entry dates should be **between the start of the assignment and the deadline (October 10, 2026)**.
>
> 💡 **TIP:** Write an entry at the **end of each work session**, while you still remember what happened. It takes 5 minutes.
>
> 💡 **TIP:** Be specific. "Worked on the code" is a weak entry. "Added a `static int contextSwitches` counter and incremented it before `currentThread.start()`" is a strong one.
>
> 📌 **NOTE:** Each entry needs: date and time, what you did, details, challenges, solution, and time spent. Real challenges are fine (and expected). Do not invent fake ones.

## Example Entry (do not copy it, write your own)

### Entry 1 - [September 22, 2026, 2:30 PM]
**What I did**: Forked the repository and set up my student ID

**Details**:
- Created GitHub account with university email
- Forked the starter repository and renamed it
- Changed student ID on line 150 to my actual ID (441234567)
- Compiled and ran the program successfully
- Committed and pushed: `Set my student ID: 441234567`

**Challenges**: Had to install JDK first because `javac` wasn't recognized

**Solution**: Downloaded JDK 17 and set the PATH variable

**Time spent**: 30 minutes

---

## Your Development Log

### Entry 1 - [October 10, 2026, 9:00 AM]
What I did: Set up my development environment and prepared the assignment project.

Details:

* Downloaded and installed Visual Studio Code.
* Opened my assignment project.
* Located SchedulerSimulation.java.
* Changed the student ID on line 150 to my own student ID.

Challenges: I needed to set up the development environment before working on the assignment.

Solution: I installed Visual Studio Code and opened the project to begin working on the code.

Time spent:  1 hour
---

### Entry 2 - [ October 10, 2026, 8:00 ]
What I did: Implemented Feature 1: Process Priority.

Details:

* Worked on adding priority information to the simulated processes.
* Reviewed the related Java code.
* Checked the changes before moving to the next feature.

Challenges: I needed to understand where the priority information belonged in the existing code.

Solution: I reviewed the relevant parts of the code and worked on the feature step by step.

Time spent: 1 hour

---

### Entry 3 - [October 10, 2026, 7:00]
What I did: Implemented Feature 2: Context Switch Counter.

Details:

* Worked on the context switch counter.
* Reviewed how the scheduler selects a thread from the ready queue.
* Practiced saving and uploading code changes using GitHub Commit and Push.

Challenges: I needed to understand how to manage my code changes and upload them to GitHub.

Solution: I practiced the Commit and Push workflow in Visual Studio Code.

Time spent: 1 hour


---

### Entry 4 - [October 10, 2026, 8:00]
What I did: Implemented Feature 3: Waiting Time Tracking.

Details:

* Worked on tracking the waiting time of simulated processes.
* Reviewed the waiting time summary in the program output.
* Practiced saving and pushing the latest changes.

Challenges: I needed to check that the waiting time information was displayed correctly.

Solution: I ran the program and reviewed its output.

Time spent: 1 hour

---

### Entry 5 - [October 10, 2026, 9:00]
What I did: Tested the scheduler output and reviewed the ready queue behavior.

Details:

* Ran the program and reviewed the process scheduling output.
* Observed messages showing processes returning to the ready queue.
* Recorded the requeue results from my run: P3, P5, P7, and P9 returned once each, while P8 returned twice.
* Calculated a total of six requeue events from the output I observed.

Challenges: I needed to distinguish the number of requeue events from the number of different processes that returned to the queue.

Solution: I counted each requeue message and checked the process names and counts.

Time spent: 30 hour


---


## Development Log Summary

>Total time spent on assignment: Approximately 6 hours  spread across multiple sessions

Most challenging part: Learning how to modify the Java code and use GitHub Commit and Push correctly

Most interesting learning: Understanding how the Round Robin scheduler manages processes and tracks waiting time

What I would do differently next time: I would start earlier review the code carefully, and test each feature after implementing it

---

# Part B: Reflection (0.5 mark)

> 🛑 **STOP:** Do **not** start this part until you have read the `README.md`, read the **entire** `SchedulerSimulation.java`, run it, and finished the three features.
>
> ⚠️ **WARNING:** Each answer must be **5 to 7 sentences**, in **your own words**. Copied or AI-generated answers without understanding get **0 marks for the whole assignment**. You may be asked to explain them in person.
>
> 💡 **TIP:** Mention concrete things you actually did: a method you wrote, an error you hit, a line of output you saw. Generic answers score low.
>
> 💡 **TIP:** Draft your answer in a few bullet points first, then turn them into sentences.

## Question 1: What did you learn about multithreading?

> 💡 **TIP:** Talk about thread creation (`Runnable`, `Thread.start()`), waiting with `Thread.join()`, simulating work with `Thread.sleep()`, and what surprised you.

**Your Answer:** *(5-7 sentences)*

I learned that multithreading allows a program to run tasks using threads. Thread.start() starts a thread, and Thread.sleep() pauses it temporarily. Thread.join() makes the main thread wait for another thread to finish. In my assignment, Process implements Runnable. I also learned how Round Robin gives each process a limited CPU time called a time quantum

## Question 2: What was the most challenging part of this assignment?

> 💡 **TIP:** Pick **one** specific challenge (understanding the code, one of the features, Git, the video) and say *why* it was hard.

**Your Answer:** *(5-7 sentences)*

The most challenging part was modifying the Java code correctly. I needed time to understand the existing code. I also had to learn how to use Visual Studio Code. Learning GitHub Commit and Push was another challenge. Working on each feature separately helped me manage the assignment

## Question 3: How did you overcome the challenges you faced?

> 💡 **TIP:** Describe your method: reading documentation, adding `System.out.println` to debug, re-reading the README, testing after each small change, asking for help.

**Your Answer:** *(5-7 sentences)*

I worked on the assignment one feature at a time. I reviewed the code to understand where changes were needed. I asked questions when I needed help understanding a concept. I also checked the program output while working on the assignment. This helped me understand the code and the scheduling process better

## Question 4: How can you apply multithreading concepts in real-world applications?

> 💡 **TIP:** Use real applications you know (web browser, game, mobile app, music player) and connect each one to what you built here.

**Your Answer:** *(5-7 sentences)*

Operating systems can share CPU time between processes using scheduling algorithms. Round Robin gives each process a time quantum before moving to the next one. This helps share CPU time fairly. Web browsers can also download files while users browse websites. Multithreading helps applications handle tasks without blocking other activities

### Optional: What would you like to learn more about?

[Any topics related to threading or operating systems that you're curious about?]

### Optional: How confident do you feel about multithreading concepts now?

[Beginner / Intermediate / Confident. What do you understand well? What needs more practice?]

### Optional: Feedback on the assignment

[Any comments? Was it helpful? Too easy or hard? Suggestions?]

---

# Part C: Technical Answers (0.5 mark)

> 🛑 **STOP:** You cannot answer these questions without understanding the code. Re-read `SchedulerSimulation.java` and **run it** first. Your answers must reference **your own code and your own output** (your student ID makes your output unique).
>
> ⚠️ **WARNING:** Each answer must be **3 to 5 sentences**, with specific examples from your code or output. Use correct terms: thread, process, time quantum, ready queue, context switch, burst time.
>
> 💡 **TIP:** Keep your program output in a text file or screenshot so you can copy real snippets for Question 2.

## Question 1: Thread vs Process

**Question**: Explain the difference between a **thread** and a **process**. Why did we use threads in this assignment instead of creating separate processes? Mention at least **TWO** specific differences (e.g., memory sharing, creation overhead, communication speed), and reference relevant parts of `SchedulerSimulation.java`.

> 💡 **TIP:** Note that the class named `Process` in our code is a *simulated* process, and it is run by a real Java *thread*. Explain that distinction and point to the `new Thread(process)` line in `addProcessToQueue()`.

**Your Answer:** *(3-5 sentences)*

A process is a program with its own memory, while threads share resources within a process. In my code, the Process class represents a simulated process. The statement new Thread(process) creates a thread to execute it.

## Question 2: Ready Queue Behavior

**Question**: In Round-Robin scheduling, what happens when a process doesn't finish within its time quantum? Explain using an example from **your** program output, including **how many times that process was re-queued** before it finished, and explain why re-queueing matters for fairness.

> ⚠️ **WARNING:** The output snippet must come from **your own run** (with your student ID), not from a classmate or from this README.
>
> 💡 **TIP:** Pick a process with a large burst time (e.g., more than 2 × time quantum) and count how many "added to ready queue" lines it has after the first one. Search your console for its name (e.g., `P3`).

**Your Answer:** *(3-5 sentences)*

In Round Robin, unfinished processes return to the end of the Ready Queue. In my output, P8 returned twice, while P3, P5, P7, and P9 returned once each. The total requeue count was 6.

Example from my output:
```
[PP3 returned to Ready Queue. Requeue count: 1
P5 returned to Ready Queue. Requeue count: 1
P7 returned to Ready Queue. Requeue count: 1
P8 returned to Ready Queue. Requeue count: 1
P9 returned to Ready Queue. Requeue count: 1
P8 returned to Ready Queue. Requeue count: 2]
```

**Explanation of example:**
These lines show that P8 returned to the Ready Queue twice, while the other listed processes returned once each. The total number of re-queue events shown is six.


## Question 3: Thread Lifecycle

**Question**: A thread goes through these states: **New**, **Runnable**, **Running**, **Waiting**, **Terminated**. Walk through these states for one process (e.g., P1) from your simulation. For each state, explain **when** P1 enters it and **which line or method call** triggers the transition (`Thread.start()`, `Thread.join()`, `Thread.sleep()`, etc.).

> 💡 **TIP:** Follow P1 through the code: created in `addProcessToQueue()`, started in the scheduler loop, sleeping inside `run()`, and the main thread waiting on `join()`. Remember that **the main thread waits** on `join()`, while **P1's thread sleeps** in `Thread.sleep()`. Be clear about which thread is in which state.

**Your Answer:** *(3-5 sentences overall; one short explanation per state)*

1. **New**: P1’s thread is created by new Thread(process) in addProcessToQueue().

2. **Runnable**:  P1 becomes eligible to run when Thread.start() is called.

3. **Running**: P1 executes its run() method when the Java scheduler gives it CPU time.

4. **Waiting**:  P1 may pause in Thread.sleep(), while the main thread can wait for P1 using Thread.join().

5. **Terminated**:  P1’s thread reaches this state when its run() method finishes.

## Question 4: Real-World Applications

**Question**: Give **TWO** real-world examples where Round-Robin scheduling with threads would be useful. **At least one** must be an operating-system-level scenario (e.g., how an OS scheduler shares CPU time among running programs). The second can be any application you choose. For each, explain what the system is and **why Round-Robin fits** (fairness, responsiveness, predictability).

> 💡 **TIP:** Relate each example back to your simulation: what plays the role of the "process", the "time quantum" and the "context switch" in that scenario?

**Your Answer:** *(3-5 sentences per example)*

### Example 1 (operating-system level): Operating-System CPU Scheduling

**Description**: Description: An operating system can use Round Robin to share CPU time among processes. Each process receives a time quantum, and an unfinished process returns to the Ready Queue. This helps provide fair CPU access and predictable turns.
[Describe the real-world scenario.]

**Why Round-Robin works well here**:
 The time quantum limits how long each process runs before another gets a turn. The scheduler switches execution between processes, helping prevent one process from monopolizing the CPU

### Example 2: Multitasking Application Web Browser

**Description**: A browser can download files while the user browses websites. Multithreading allows different tasks to run without blocking other activities. This helps the browser remain responsive.


**Why Round-Robin works well here**:
 Round Robin can distribute CPU time fairly among runnable threads. Context switches allow the CPU to move between tasks, helping the application remain responsive when several tasks need processing.

## Summary

**Key concepts I understood through these questions:**
1.The difference between a simulated process and a Java thread
2. How Round Robin uses a time quantum and Ready Queue.
3. How threads move through their lifecycle states.


**Concepts I need to study more:**
1. Thread synchronization
2. Other CPU scheduling algorithms

---

# ✅ Final Checklist (complete before submitting)

> ⚠️ **WARNING:** Go through every line. Late submission costs **-1 mark per day**, and the deadline is **October 10, 2026**.

**Repository**
- [ ] Repository is **PUBLIC** (Settings → Danger Zone → Visibility)
- [ ] Repository is renamed to `OS-Assignment1-YourFirstName-YourLastName`
- [ ] GitHub account uses the university email (`@std.psau.edu.sa`)

**Code**
- [ ] Student ID is set in `SchedulerSimulation.java` (line 150)
- [ ] Code compiles and runs with no errors
- [ ] Feature 1 (priority), Feature 2 (context switches) and Feature 3 (waiting time table) all work
- [ ] Each feature has clear comments

**Commits**
- [ ] **At least 3 meaningful commits, ideally 6 or more**
- [ ] **One commit per feature**
- [ ] Commits are spread over **different dates** (not all in the last hour)
- [ ] Everything is **pushed** to GitHub

**This file (`MY_WORK.md`)**
- [ ] Full name and student ID filled in at the top
- [ ] Development log has **5+ entries** on different dates
- [ ] Reflection: 4 questions, 5-7 sentences each
- [ ] Technical answers: 4 questions, 3-5 sentences each, with examples from **your** output
- [ ] No `[...]` placeholders left
- [ ] No section headers deleted

**Video**
- [ ] 2-3 minutes long, named `StudentID_Assignment1_Demo.mp4`
- [ ] Shows your name, ID, repository, 3 features, IDE execution, one threading concept, and commit history
- [ ] Link is **public** (tested in an incognito window) and pasted in the **Video Link** section above

**Blackboard**
- [ ] Submit **only** the link to your public GitHub repository

> 🎯 **Good luck!** Start early, commit regularly, and make sure you can explain every line you submit.
