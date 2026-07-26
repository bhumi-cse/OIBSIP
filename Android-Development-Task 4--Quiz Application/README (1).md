# OIBSIP---3
TASK 4 QUIZ APPLICATION
# 🧠 BrainQuest - Quiz Application

An interactive multiple-choice **Quiz Application** built using **Java and Android SDK**. BrainQuest provides an engaging testing experience with randomized questions, real-time option color validation, and complete score analytics.

## ✨ Features

* 🔀 Automatic Question Shuffling using Collections Framework
* 🎯 Real-time Option Color Feedback (Green for correct, Red for wrong)
* 🔒 Selection Lock to prevent multi-option clicking per question
* 📊 Comprehensive Result Screen showing total score, correct, and wrong counts
* 🔁 Restart Quiz functionality to retake tests seamlessly
* 📱 Multi-Activity Flow connected via Android Intent & Bundle Extras

## 🛠️ Built With

* Java (JDK 17)
* Android Intents & Bundle Data Transfer
* Custom Model Classes (`Question.java`)
* Android Studio IDE

## 📁 Project Structure
```<pre>
QuizApp/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/quizapp/
│           │   ├── MainActivity.java
│           │   ├── QuizActivity.java
│           │   ├── ResultActivity.java
│           │   └── Question.java
│           ├── res/
│           │   └── layout/
│           │       ├── activity_main.xml
│           │       ├── activity_quiz.xml
│           │       └── activity_result.xml
│           └── AndroidManifest.xml
</pre>
## 🚀 How to Run

1. Clone this repository to your local machine.
2. Open the project directory in **Android Studio**.
3. Sync project with Gradle files.
4. Press **Run (Shift + F10)** to launch the application.

## 📌 Learning Outcomes

Through this project, I gained hands-on experience with:

* Multi-screen activity navigation using Intents
* Data parsing using Bundle Extras
* OOP data modeling with custom Java objects
* Dynamic UI color manipulation based on logic checks

## 🌟 Future Improvements

* Category selection (Tech, Science, History)
* Countdown timer for each question
* Firebase Realtime Database integration for dynamic question fetching
* High-score leaderboard system

## 🧑‍💻 Author

**Bhumi**  
Computer Engineering Student | Mobile App Developer

---
⭐ Thank you for visiting this project!
