# 🧮 Python BMR & TDEE Calculator

A simple Python-based calculator that helps you estimate your **Basal Metabolic Rate (BMR)**, **Total Daily Energy Expenditure (TDEE)**, and personalized calorie goals for weight maintenance, loss, or gain.  

This project is perfect for anyone learning Python basics while building something practical for fitness and nutrition tracking.

---

## 🚀 Features
- Converts **weight (lbs → kg)** and **height (ft/in → cm)** automatically.
- Calculates **BMR** using the Mifflin-St Jeor Equation:
  - Male: `(10 × kg) + (6.25 × cm) - (5 × age) + 5`
  - Female: `(10 × kg) + (6.25 × cm) - (5 × age) - 161`
- Estimates **activity level multiplier** based on minutes of activity per day:
  - Sedentary (≤ 60 min) → `1.2`
  - Light (≤ 150 min) → `1.375`
  - Moderate (≤ 300 min) → `1.55`
  - Very Active (≤ 420 min) → `1.725`
  - Extra Active (> 420 min) → `1.9`
- Outputs:
  - **BMR** (calories burned at rest)
  - **TDEE** (calories burned daily with activity)
  - Calorie goals for:
    - Maintenance
    - Mild loss (-250 kcal)
    - Moderate loss (-500 kcal)
    - Mild gain (+250 kcal)
    - Moderate gain (+500 kcal)

---

## 📦 Installation
Clone the TDEE/BMR python code and run the script with Python 3



