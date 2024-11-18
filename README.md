
# Golf Tournament API

Welcome to the **Golf Tournament API**, a RESTful API designed for managing golf tournaments and club members. This API allows you to perform basic CRUD operations on a MySQL database.

---

## Prerequisites

- **MySQL**: The database must be set up locally on your machine.
- **Docker**: Used to containerize and run the application.
- **Postman** (or any API client): To test the API endpoints.

---

## Setup Instructions

Follow these steps to set up and run the API on your local machine:

### 1. Clone the Repository
```bash
git clone <repository-url>
cd <repository-folder>
```

### 2. Set Up MySQL Database
1. Open a terminal and start MySQL:
   ```bash
   mysql -u root -p
   ```
2. Create the database:
   ```sql
   CREATE DATABASE golfclubdb;
   ```
   > Note: The required tables will be created automatically when the application is first run.

### 3. Build and Run the Docker Container
1. Build the Docker image:
   ```bash
   docker build -t server:latest .
   ```
2. Run the container:
   ```bash
   docker run -d -p 8080:8080 server:latest
   ```

---

## Using the API

After the setup is complete, you can interact with the API using tools like **Postman** or through direct HTTP requests.

### Base URL
```
http://localhost:8080
```

### Endpoints

#### **Members**
- **GET** `/members`  
  Retrieve all members.
  
- **GET** `/members/{id}`  
  Retrieve a specific member by ID.
  
- **GET** `/members/phone/{phoneNumber}`  
  Retrieve a member by phone number.

- **POST** `/members`  
  Create a new member.  
  _Payload Example:_
  ```json
  {
    "name": "John Doe",
    "address": "123 Seasame Street",
    "email": "john@gmail.com",
    "phone": "7097691056",
    "start_date": "2024-10-11"
   }
  ```

- **PUT** `/members/{id}`  
  Update a member by ID.  
  _Payload Example:_
  ```json
  {
    "name": "John Doe",
    "address": "123 Seasame Street",
    "email": "john@gmail.com",
    "phone": "7097691056",
    "start_date": "2024-10-11"
}
  ```

- **DELETE** `/members/{id}`  
  Delete a member by ID.

#### **Tournaments**
- **GET** `/tournaments`  
  Retrieve all tournaments.
  
- **GET** `/tournaments/{id}`  
  Retrieve a specific tournament by ID.
  
- **GET** `/tournaments/location/{location}`  
  Retrieve tournaments at a specific location.  
  _Example:_  
  ```
  http://localhost:8080/tournaments/location/st-johns-golf-club
  ```

- **GET** `/tournaments/date/{date}`  
  Retrieve tournaments on a specific date.  
  _Example:_  
  ```
  http://localhost:8080/tournaments/date/2024-11-12
  ```

- **POST** `/tournaments`  
  Create a new tournament.  
  _Payload Example:_
  ```json
  {
    "start_date": "2024-11-25",
    "end_date": "2024-11-27",
    "location": "Atlantic Golf Center",
    "prize": "750.00",
    "entry_fee": "75.00",
    "members": [1, 3]
}
  ```

- **PUT** `/tournaments/{id}`  
  Update a tournament by ID.  
  _Payload Example:_
  ```json
  {
    "start_date": "2024-11-25",
    "end_date": "2024-11-27",
    "location": "Atlantic Golf Center",
    "prize": "750.00",
    "entry_fee": "75.00",
    "members": [1, 3]
}
  ```

- **DELETE** `/tournaments/{id}`  
  Delete a tournament by ID.

---

## Example Usage in Postman

### 1. Retrieve All Members
**GET** Request to:  
```
http://localhost:8080/members
```

### 2. Add a New Tournament
**POST** Request to:  
```
http://localhost:8080/tournaments
```
**Body:**
```json
{
  "name": "Spring Invitational",
  "location": "Green Valley",
  "date": "2025-03-10"
}
```

---

Feel free to contribute, report issues, or enhance the API further. Happy golfing! ⛳
