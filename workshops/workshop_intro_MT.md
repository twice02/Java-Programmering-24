# Workshop 1 - Walkthrough (genomgång)
## User registration
```java
function registerUser(username, email, password, confirmPassword):
    if username is empty or email is empty:
        display "Please fill out all obligatory fields"
    if password is not equal to confirmPassword:
        display "Passwords do not match"
    if password is less than 8 characters:
        display "Password must be at least 8 characters"
    if username, email, and password are valid:
        save user to database
        redirect to homepage
    else:
        display "Registration failed"
```

## E-commerce checkout

```java
function checkout(cartItems, paymentMethod):
    if cartItems is empty:
        display "Your cart is empty"
    if paymentMethod is invalid:
        display "There was an error with your payment"
    total = calculateTotal(cartItems)
    if total exceeds user balance:
        display "Insufficient funds"
    else:
        deduct total from user balance
        display "Purchase successful"
```


# Workshop 2 - Checklist-based 

## User Manual for Mobile App
```java
1. Open the app and create an account.
2. Navigate to the settings tab to customize your profile.
3. Use the search bar to find items in the store.
4. Add items to your cart and proceed to checkout.
5. View order history by selecting 'Orders' from the menu.
```
### Checklist for review
```
☐  Are the instructions detailed enough for users unfamiliar with mobile apps?

☐  Is there sufficient information about navigating the interface?

☐  Does the manual explain what happens if the search bar returns no results?

☐  Are there any missing steps or ambiguous terms?
```  
___  
___
  

## Customer Service Process Document 
```java
1. Customers can contact support via phone, email, or live chat.
2. All requests should be answered within 24 hours.
3. Critical issues must be escalated to a manager immediately.
4. Support representatives should offer a follow-up call or email to ensure satisfaction.
5. Surveys should be sent after the issue is resolved to gauge customer satisfaction.
```

### Checklist for review
```
☐  Is the escalation process well-defined for critical issues?

☐  Are there clear criteria for what constitutes a "critical" issue?

☐  Is there enough information about how follow-up calls should be scheduled or tracked?

☐  Are there potential gaps in the process?
```  
___  
___

## File Uploading System

```java
1. The system should allow users to upload files up to 10MB.
2. Uploaded files should be scanned for viruses.
3. The system should automatically delete files that have not been accessed for 30 days.
4. The system should provide a way to recover deleted files.
5. The interface must be responsive and work on both desktop and mobile devices.
```

### Checklist for review
```
☐  Is there enough detail on the file upload process?

☐  Are there security concerns?

☐  Is the recovery process for deleted files well-defined?

☐  Does the specification cover edge cases, such as what happens when a file is too large or corrupted?
```
---
# Scenario-based


## Scenario 1: Newsletter
### Scenario description
>A user is attempting to submit a form to sign up for a newsletter, but when they press the "Submit" button, nothing happens.
___
### Objective
>Review the user report and system log. Identify potential causes of the form submission failure and suggest improvements for better user feedback and handling of errors.
___
### User report(s)
```vbnet
User: john.doe@example.com
Date: Sept 10, 2024

Description: I filled out the newsletter form, but after clicking "Submit," the form just reset, and I did not get any confirmation or email. I’m sure I filled out everything correctly.
```
### Log messages
```cpp
[09/10/2024 10:30] WARNING: Form submission failed - missing required field 'Email'.
[09/10/2024 10:31] INFO: Form reset for user john.doe@example.com.
```

### Form requirements
- All required fields (Name, Email) must be filled before submission.
- A success message should appear after successful submission.
- Users should receive a confirmation email within 5 minutes.


##
## Scenario 2: E-commerce

### Scenario description
> Several users have complained about failed transactions while trying to purchase items in your e-commerce app.

### Objective 
> Analyze the user reports, payment gateway logs, and system requirements. Identify what might be causing the payment failures and the discrepancy between the bank deductions and transaction failures. Propose potential improvements to the app’s error handling and user communication.

### User reports 
```cpp
User1 (ID: 54321):
"I tried to buy a pair of sneakers, but after completing the payment, I was shown a 'Transaction Failed' page. However, my bank shows that the money was deducted. I haven't received a confirmation email."

User2 (ID: 98765):
"I tried to check out with my cart, and it took me to a failure page after I entered my card details. I contacted my bank, and they said the payment went through, but I don’t see the purchase in my order history."
```

### Log messages
```csharp
[09/06/2024 14:10] INFO: Transaction ID 768491 processed for user 54321.
[09/06/2024 14:10] WARNING: Gateway timeout for Transaction ID 768491, payment gateway response delayed.
[09/06/2024 14:10] ERROR: Order confirmation failed for Transaction ID 768491.
```

### App requirements
The app requirements provided: 
- All transactions must provide immediate feedback to users.
- Payment processing failures must provide users with a detailed error message, explaining the next steps.
- The system must not deduct funds from user accounts unless the order is successfully placed.


## Scenario 3: E-commerce

### Scenario description
> Users are reporting that their fitness data (e.g., steps, heart rate) is not syncing correctly between their wearable device and the mobile app. Some data appears on the app after long delays, while other data doesn’t sync at all. Upon investigation, the logs show intermittent connectivity issues and missing data packets from the wearable device.

### Objective 
> Analyze the user reports and system logs to determine why data synchronization is inconsistent. Propose potential fixes and improvements to make the syncing process more reliable and responsive.

### User reports 
```vbnet
User: fitness.guru@gymbro.com
Date: Sept 18, 2024

Description: "My steps are not syncing with the app. I walked around 10,000 steps today, but the app only shows 3,500. It took over an hour for my heart rate to update as well."

User: dumbrunner@marathon5ever.com
Date: Sept 19, 2024

Description: "The app is not syncing with my fitness band properly. Sometimes it takes hours to see the updates, and some days, nothing syncs at all. I need to share my run, otherwise, did it even happen??!!!111"

```

### Log messages
```csharp
[09/18/2024 07:30] INFO: Attempting to sync data from device ID 8765 to user fitness.guru@gymbro.com.com.
[09/18/2024 07:31] ERROR: Sync failed - packet loss detected during transmission (steps data missing).
[09/18/2024 07:32] WARNING: Retry sync for heart rate data - connection unstable.

[09/19/2024 08:00] INFO: Sync initiated for user dumbrunner@marathon5ever.com.
[09/19/2024 08:05] ERROR: Sync timeout - unable to retrieve data from device ID 6789.

```

### System requirements
The app requirements provided: 
- Sync must occur within 5 minutes of data being available on the wearable device.
- Partial data loss should trigger a retry mechanism to ensure full synchronization.
- If a sync fails, users should be notified with a clear error message and troubleshooting options.
