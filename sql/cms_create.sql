CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50),
    affiliation VARCHAR(255)
);

CREATE TABLE Conference (
    conf_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    start_date DATE,
    end_date DATE,
    location TEXT
);

CREATE TABLE PaperSubmission (
    paper_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    conf_id INT,
    title VARCHAR(255),
    abstract TEXT,
    file_path TEXT,
    submission_date DATE,
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (conf_id) REFERENCES Conference(conf_id)
);

CREATE TABLE Payment (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    paper_id INT,
    amount DECIMAL(10, 2),
    payment_date DATE,
    status VARCHAR(50),
    payment_method VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (paper_id) REFERENCES PaperSubmission(paper_id)
);

CREATE TABLE Venue (
    venue_id INT PRIMARY KEY AUTO_INCREMENT,
    venue_name VARCHAR(255) NOT NULL,
    address TEXT,
    capacity INT,
    type VARCHAR(50)
);

CREATE TABLE Certificate (
    cert_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    paper_id INT,
    issue_date DATE,
    cert_type VARCHAR(50),
    file_path TEXT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (paper_id) REFERENCES PaperSubmission(paper_id)
);

CREATE TABLE Schedule (
    schedule_id INT PRIMARY KEY AUTO_INCREMENT,
    paper_id INT,
    session_name VARCHAR(255),
    presenter_id INT,
    time TIME,
    room VARCHAR(50),
    FOREIGN KEY (paper_id) REFERENCES PaperSubmission(paper_id),
    FOREIGN KEY (presenter_id) REFERENCES Users(user_id)
);

CREATE TABLE Author (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    name VARCHAR(255),
    affiliation VARCHAR(255),
    email VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Acceptance (
    accept_id INT PRIMARY KEY AUTO_INCREMENT,
    paper_id INT,
    decision VARCHAR(50),
    letter_sent DATE,
    send_date DATE,
    FOREIGN KEY (paper_id) REFERENCES PaperSubmission(paper_id)
);

CREATE TABLE Review (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    paper_id INT,
    reviewer_id INT,
    score INT,
    comments TEXT,
    review_date DATE,
    FOREIGN KEY (paper_id) REFERENCES PaperSubmission(paper_id),
    FOREIGN KEY (reviewer_id) REFERENCES Users(user_id)
);

CREATE TABLE Registration (
    red_id INT PRIMARY KEY AUTO_INCREMENT,
    conf_id INT,
    user_id INT,
    reg_date DATE,
    reg_type VARCHAR(50),
    fee DECIMAL(10, 2),
    payment_status VARCHAR(50),
    FOREIGN KEY (conf_id) REFERENCES Conference(conf_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    conf_id INT,
    user_id INT,
    checkin_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    checkout_time TIMESTAMP NULL,  
    status VARCHAR(50),
    FOREIGN KEY (conf_id) REFERENCES Conference(conf_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Invoice (
    invoice_id INT PRIMARY KEY AUTO_INCREMENT,
    payment_id INT,
    issue_date DATE,
    due_date DATE,
    total_amount DECIMAL(10, 2),
    status VARCHAR(50),
    FOREIGN KEY (payment_id) REFERENCES Payment(payment_id)
);

CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    conf_id INT,
    rating INT,
    comments TEXT,
    date DATE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (conf_id) REFERENCES Conference(conf_id)
);

CREATE TABLE Notification (
    notif_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    message TEXT,
    data_sent DATE,
    status VARCHAR(50)
);
