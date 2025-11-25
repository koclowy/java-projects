#  OneMinute – Survival Strategy Game (Advanced Programming Project)

**OneMinute** is a JavaFX survival strategy game where players try to endure a pandemic lockdown for 30 days.  
Every decision impacts the family’s **hunger**, **thirst**, **morale**, and **health**.  
Players shop for supplies, manage daily events, make journal choices, survive random challenges, and aim to reach Day 30.

A key highlight of this project:  
### **All artworks (characters, backgrounds, UI, icons) were hand-drawn by me using Procreate and Pixel Studio.**

---

## Objectives  

- Create an interactive survival game using JavaFX and OOP concepts  
- Implement multi-screen navigation (Login → Storyline → Shopping → Cashier → Day Counter → Home → Journal → Win/Defeat)  
- Integrate game logic such as resource management, daily events, status updates  
- Provide an immersive user experience using pixel-art visuals and background music  
- Build a login system with register, reset password, and validation  
- Use JavaFX components such as AnchorPane, ImageView, Buttons, Labels, TilePane, etc.  
- Manage game progression with event handling, timers, animations, and save features  

---

## Tools & Technologies

### **Language**
- Java

### **Frameworks & Libraries**
- **JavaFX** (core UI framework)  
- **FXML** (UI markup)
- **MediaPlayer** (audio and sound effects)

### **Tools**
- **Visual Studio Code** – main IDE  
- **Apache NetBeans** – alternative development  
- **Scene Builder** – drag-and-drop UI creation  
- **Procreate** – hand-drawn artwork (characters, icons, screens)  
- **Pixel Studio** – pixel-art assets  
- **Figma** – UI/UX prototyping and screen flows  
- **Draw.io** – diagrams (flowcharts, logic, system design)  
- **ChatGPT** – documentation, debugging, idea refinement  

---

## Gameplay Overview  

### Login & User System
- Login, Register, Reset Password  
- Password validation & error alerts  
- Data stored in encrypted local files  

### Storyline Screens
- Intro story fades in gradually  
- Animated transition buttons  
- Setup for the 30-day survival challenge  

### 60-Second Shopping Phase
- Player selects items from shelves  
- Items include water, canned food, medicine, bug spray, etc.  
- Time pressure: 60-second timer  
- Tooltip descriptions for each item  

### Cashier Review
- Player reviews selected items before starting lockdown  

### Day Counter (Day 1–30)
- “Next Day” logic with updated hunger/thirst/morale  
- Scenes transition using JavaFX animations  

### Home Screen
- Access Journal Story and Journal Status  
- Pause game (Continue / Save / Quit)  

### Journal Decisions (Daily Events)
Based on pages 17–22 (Yes/No choices).  
Each day includes:

- Story event  
- 2 decision choices (Yes / No)  
- Status changes to health, hunger, thirst, morale  
- Effects displayed in the journal text area  
- Move to next day  

### Win / Defeat Conditions
- **Win:** Survive all 30 days :contentReference[oaicite:5]{index=5}  
- **Lose:** Health/morale/hunger/thirst reaches 0, or 2 family members die  

---

## File Structure

```plaintext
Advanced Programming/oneminute/
│
├── docs/                     # Documentation, UI plans, diagrams
│
├── src/oneminute/            # Full Java source code (JavaFX + OOP)
│
└── README.md                 # Project documentation
```
---
## What I Learned

Through this project, I gained hands-on experience in:

- JavaFX GUI development
- Organizing code using MVC & OOP principles
- File handling & encrypted data storage
- Multi-screen navigation using FXML
- Handling events, timelines, and animations
- Pixel-art & digital illustration integration
- Creating custom UI components (buttons, transitions, icons)
- Managing game state and logic (resources, choices, survival events)
- Designing intuitive UX with Figma and Scene Builder
- Collaborative development & documentation
- Debugging JavaFX applications and audio integration

---

## Future Enhancements

- Add settings menu (audio, graphics, controls, language)
- Expand lockdown duration from 14 days → full 30 days
- Add sound settings & volume controls
- Add more random events and varied difficulty modes
- Enhance visual polish and animations
- Improve journal UI navigation
- Add character movement or micro-animations
- Expand storyline & endings

---
