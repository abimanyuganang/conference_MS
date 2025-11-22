INSERT INTO venue (venue_id, venue_name, address, capacity, type) VALUES
(1, 'Main Auditorium', 'Universiti Utara Malaysia, Sintok, Kedah, Malaysia', 1000, 'Conference'),
(2, 'Room 101', 'Universiti Utara Malaysia, Sintok, Kedah, Malaysia', 150, 'Workshop'),
(3, 'Room 102', 'Universiti Utara Malaysia, Sintok, Kedah, Malaysia', 100, 'Seminar');

INSERT INTO conference (conf_id, name, year, start_date, end_date, location) VALUES
(1, 'International Conference on Information Technology', 2025, '2025-06-01', '2025-06-03', 'Main Auditorium, Universiti Utara Malaysia'),
(2, 'UUM AI and Robotics Symposium', 2025, '2025-07-01', '2025-07-02', 'Room 101, Universiti Utara Malaysia'),
(3, 'UUM Academic Research and Development Conference', 2025, '2025-08-10', '2025-08-12', 'Room 102, Universiti Utara Malaysia');

INSERT INTO users (user_id, name, email, password, role, affiliation) VALUES
(1, 'Dr. Ahmad Fadhil', 'ahmad.fadhil@uum.edu.my', 'password123', 'Presenter', 'School of Computing, Universiti Utara Malaysia'),
(2, 'Prof. Nor Azlan', 'nor.azlan@uum.edu.my', 'password456', 'Reviewer', 'Faculty of Engineering, Universiti Utara Malaysia'),
(3, 'Ms. Amina Zain', 'amina.zain@uum.edu.my', 'password789', 'Attendee', 'Student, Universiti Utara Malaysia');

INSERT INTO papersubmission (paper_id, user_id, conf_id, title, abstract, file_path, submission_date, status) VALUES
(1, 1, 1, 'AI in Education: Enhancing Learning with Technology', 'This paper explores how AI can be used to enhance education.', '/papers/ai_education.pdf', '2025-04-15', 'Submitted'),
(2, 1, 2, 'Robotics in Malaysian Industries', 'This paper discusses the impact of robotics on various industries in Malaysia.', '/papers/robotics_malaysia.pdf', '2025-05-20', 'Accepted');

INSERT INTO author (author_id, user_id, name, affiliation, email) VALUES
(1, 1, 'Dr. Ahmad Fadhil', 'School of Computing, Universiti Utara Malaysia', 'ahmad.fadhil@uum.edu.my');

INSERT INTO payment (payment_id, user_id, paper_id, amount, payment_date, status, payment_method) VALUES
(1, 1, 1, 250.00, '2025-04-15', 'Paid', 'Bank Transfer'),
(2, 3, 2, 150.00, '2025-05-21', 'Paid', 'Credit Card');

INSERT INTO certificate (cert_id, user_id, paper_id, issue_date, cert_type, file_path) VALUES
(1, 1, 1, '2025-06-04', 'Presenter', '/certificates/ai_education_cert.pdf'),
(2, 3, 2, '2025-08-01', 'Attendee', '/certificates/uum_attendee_cert.pdf');

INSERT INTO schedule (schedule_id, paper_id, session_name, presenter_id, time, room) VALUES
(1, 1, 'AI in Education', 1, '10:00:00', 'Main Auditorium'),
(2, 2, 'Robotics in Malaysian Industries', 1, '14:00:00', 'Room 101');

INSERT INTO acceptance (accept_id, paper_id, decision, letter_sent, send_date) VALUES
(1, 1, 'Accepted', '2025-04-20', '2025-04-21'),
(2, 2, 'Accepted', '2025-05-25', '2025-05-26');

INSERT INTO review (review_id, paper_id, reviewer_id, score, comments, review_date) VALUES
(1, 1, 2, 9, 'Excellent work on the application of AI in education.', '2025-05-01'),
(2, 2, 2, 8, 'Great insights into robotics and its impact on industries.', '2025-06-01');

INSERT INTO registration (reg_id, conf_id, user_id, reg_date, reg_type, fee, payment_status) VALUES
(1, 1, 1, '2025-04-15', 'Early Bird', 200.00, 'Paid'),
(2, 2, 3, '2025-05-20', 'Standard', 150.00, 'Paid');

INSERT INTO attendance (attendance_id, conf_id, user_id, checkin_time, checkout_time, status) VALUES
(1, 1, 1, '2025-06-01 09:00:00', '2025-06-01 17:00:00', 'Attended'),
(2, 2, 3, '2025-07-01 08:30:00', '2025-07-01 16:00:00', 'Attended');

INSERT INTO invoice (invoice_id, payment_id, issue_date, due_date, total_amount, status) VALUES
(1, 1, '2025-04-15', '2025-05-15', 250.00, 'Paid'),
(2, 2, '2025-05-21', '2025-06-21', 150.00, 'Paid');

INSERT INTO feedback (feedback_id, user_id, conf_id, rating, comments, date) VALUES
(1, 1, 1, 5, 'Excellent conference with very engaging sessions.', '2025-06-03'),
(2, 3, 2, 4, 'The symposium was good, but could improve the networking opportunities.', '2025-07-02');

INSERT INTO notification (notif_id, title, message, data_sent, status) VALUES
(1, 'Conference Reminder', 'Your session is scheduled for 10:00 AM in Main Auditorium.', '2025-06-01', 'Sent'),
(2, 'Symposium Update', 'The Robotics Symposium has been rescheduled to 2:00 PM in Room 101.', '2025-06-15', 'Sent');
