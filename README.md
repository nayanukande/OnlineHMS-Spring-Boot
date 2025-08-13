# 🏨 Online Hotel Management System

## 📋 Overview

The **Online Hotel Management System (HMS)** is a comprehensive software solution designed to automate and streamline the core operations of a hotel. It simplifies daily tasks such as reservations, room and inventory management, guest handling, billing, and reporting. The system is built to enhance efficiency, reduce manual file handling, and improve customer service.

## 🎯 Objectives

- Automate hotel operations for improved efficiency.
- Provide a user-friendly interface for various hotel roles.
- Ensure secure and role-based access to functionalities.
- Enable quick and accurate information retrieval.
- Support error recovery and high user satisfaction.

## 👥 End Users

- **Owner**: Full access to all system functionalities.
- **Manager**: Access with limited restrictions.
- **Receptionist**: Access restricted to reservation management.

## ✨ Features

- Room and Hall Reservations
- Room Type and Service Management
- Inventory Control
- Guest Management
- Staff Management
- Billing and Payments
- Rate Setting
- Report Generation (Staff Payments, Income)
- Email Notifications
- Role-Based Login System

## ⚙️ Functional Modules

### 1. Make Reservations
- **Input**: Code, number of guests, check-in/out dates, status
- **Output**: Database record confirmation
- **Process**: Validates and stores reservation details

### 2. Add Guest
- **Input**: Member code, contact info, company, gender, address
- **Output**: Database record confirmation
- **Process**: Validates and stores guest details

### 3. Add Staff Member
- **Input**: Employee details, NIC, salary, occupation
- **Output**: Database record confirmation
- **Process**: Validates and stores staff details

### 4. Search Rooms
- **Input**: Period, check-in/out dates, guest info
- **Output**: Available room details
- **Process**: Checks availability and returns results

### 5. Add Payments
- **Input**: Total amount, payment time, credit card details
- **Output**: Database record confirmation
- **Process**: Validates and stores payment info

### 6. Issue Bill
- **Input**: Billing number, quantity, price, taxes, services
- **Output**: Printed bill
- **Process**: Calculates total cost and prints bill

### 7. Set Rates
- **Input**: Stay duration, guest count, pricing details
- **Output**: Database record confirmation
- **Process**: Validates and stores rate information

## 🛠️ Technologies Used

> *(Add your stack here, e.g., Java, Python, MySQL, HTML/CSS, etc.)*

## 🚀 Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/hotel-management-system.git
   ```
