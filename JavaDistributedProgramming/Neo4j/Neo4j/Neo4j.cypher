// Tạo node Course, Student, Department từ file csv 

LOAD CSV WITH HEADERS FROM "file:///courses.csv" AS row  // WITH HEADERS : to skip the first row (ám chỉ đến header), row là biến đại diện cho từng dòng trong file csv
MERGE (course:Course { courseID: row.course_id}) // MERGE : tạo node nếu chưa tồn tại, nếu tồn tại rồi thì không tạo nữa (nếu không có MERGE thì sẽ tạo node mới mỗi lần chạy)
SET course.name = row.name, course.hours = toInteger(row.hours) // SET : gán giá trị cho các thuộc tính của node course (toInteger : chuyển đổi kiểu dữ liệu từ string sang integer)
RETURN course // RETURN : trả về node course sau khi thực hiện các thao tác trên

LOAD CSV WITH HEADERS FROM "file:///students.csv" AS row
MERGE (student:Student { studentID: row.student_id})
SET student.name = row.name, student.gpa = toFloat(row.gpa)


LOAD CSV WITH HEADERS FROM "file:///departments.csv" AS row
MERGE (dept:Department { deptID: row.dept_id})
SET dept.name = row.name, dept.dean = row.dean, dept.building = row.building, dept.room = row.room





// Tạo CONSTRAINT cho các node Course, Student, Department
CREATE CONSTRAINT unique_course_id FOR (course:Course) REQUIRE course.courseID IS UNIQUE;
// CREATE CONSTRAINT : tạo constraint
// REQUIRE : bắt buộc thuộc tính courseID của node Course phải là duy nhất
// unique_course_id là tên của constraint, có thể đặt tên bất kỳ (nhưng phải khác nhau với các constraint khác)
// (course:Course) : ám chỉ đến node Course
// course.courseID : ám chỉ đến thuộc tính courseID của node Course
// IS UNIQUE : bắt buộc thuộc tính courseID của node Course phải là duy nhất

CREATE CONSTRAINT unique_student_id FOR (student:Student) REQUIRE student.studentID IS UNIQUE;
CREATE CONSTRAINT unique_dept_id FOR (dept:Department) REQUIRE dept.deptID IS UNIQUE;
//Hiển thị các constraint
show constraints;


// Tạo quan hệ giữa các node Course, Student, Department

LOAD CSV WITH HEADERS FROM "file:///enrollments.csv" AS row
MATCH (course:Course { courseID: row.course_id}) // MATCH : tìm node Course có courseID = row.course_id (row.course_id là giá trị trong file csv)
MATCH (student:Student { studentID:row.student_id}) // MATCH : tìm node Student có studentID = row.student_id (row.student_id là giá trị trong file csv)
MERGE (student)-[:ENROLLED]->(course) // MERGE : tạo quan hệ ENROLLED giữa node Student và node Course (nếu chưa tồn tại quan hệ thì tạo mới, nếu đã tồn tại thì không tạo nữa)


LOAD CSV WITH HEADERS FROM "file:///courses.csv" AS row
MATCH (course:Course { courseID: row.course_id})
MATCH (dept:Department { deptID: row.dept_id})
MERGE (course)-[:BELONGS_TO]->(dept)















// Một số câu lệnh

//dùng để xóa tất cả các node và quan hệ trong database
MATCH (n)  DELETE n;
//dùng để xóa tất cả các node có label Label và thuộc tính property = value
 MATCH (n:Label {property: value})
 DELETE n;


 // 1.Liệt kê danh sách n sinh viên 
MATCH (s:Student) RETURN s limit 2; 


//2.Tìm kiếm sinh viên khi biết mã số
//c1:
MATCH (S:Student) WHERE S.studentID = "S1" RETURN S;
//c2:
MATCH (s:Student {studentID:"11"})
RETURN s;


// 3. Tìm danh sách khóa học thuộc của một khoa nào đó khi biết mã khoa

//c1:
MATCH (c:Course) -[:BELONGS_TO]-> (d:Department) 
WHERE toUpper(d.deptID) = "MATH"  //toUpper : chuyển đổi chuỗi thành chữ in hoa
RETURN c; //trả về danh sách các khóa học thuộc khoa MATH

//c2:
MATCH (c:Course)-[:BELONGS_TO]->(d:Department)
WHERE d.deptID="IE" 
RETURN collect(c); //collect : trả về một mảng chứa các node Course thỏa mãn điều kiện
//c3:
MATCH (c:Course)--(d) //dấu -- : tìm tất cả các quan hệ giữa node Course và node Department (không quan trọng quan hệ là gì)
WHERE d.deptID="IE" 
RETURN collect(c); //collect : trả về một mảng chứa các node Course thỏa mãn điều kiện


//4. Cập nhật name = “Mathematics” cho department_id = “Math”
MATCH (d:Department {deptID: "MATH"})
SET d.name = "Mathematics"

//5. Cập nhật name = “Rock n Roll” cho department_id = “Music”
MATCH (d:Department {deptID: "Music"})
SET d.name = "Rock n Roll"


//6. Thêm khóa học vào khoa IE: IE202, Simulation, 3 hours
MATCH (c:Course {courseID: "IE202"})
MATCH (d:Department {deptID: "IE"})
MERGE (c)-[:BELONGS_TO]->(d)
SET c.name = "Simulation", c.hours = 3

MATCH (d:Department {deptID:"IE"}) 
CREATE (c:Course {courseID:"IE202", name:"Simulation", hours:3})-[:BELONGS_TO]->(d);


CREATE (course:Course { courseID: "IE202", name: "Simulation", hours: 3})
RETURN course;

MATCH (d:Department {deptID:IE}) // $deptID : tham số truyền vào
CREATE (c:Course {courseID:$courseID, name:$name, hours:$hours})-[:BELONGS_TO]->(d) 
RETURN c.courseID AS courseID

// 7. Xóa toàn bộ các khóa học

// Lưu ý, chỉ xóa được những node không có relationship nào.
//Có 2 cách để xóa
//- gọi detach để ngắt kết nối và xóa node.
//- xóa relationship trước.

// Ví dụ, xóa khóa học có mã số là “IE202” vừa thêm vào thì thành công vì chưa tạo relationship
MATCH (course:Course { courseID: "IE202"}) DELETE course
// Nhưng xóa khóa học có mã số là “CS101” là không thành công vì có sinh viên đã đăng ký tham gia học
MATCH (course:Course { courseID: "CS101"}) DELETE course → xóa không thành công
//Thực hiện cách 1 (DETACH)
MATCH (course:Course { courseID: "CS101"}) 
DETACH DELETE course

// Thực hiện cách 2 xóa relationship trước
MATCH(() - [r:ENROLLED]->()) DELETE r;
MATCH(() - [r:BELONGS_TO]->()) DELETE r;
MATCH (course:Course) DELETE course;




// 8. Liệt kê tất cả các khoa
MATCH (d:Department) RETURN d;

// 9.Liệt kê tên của tất cả các trưởng khoa
MATCH (d:Department) RETURN d.dean AS tenTruongKhoa;


// 10. Tìm tên của trưởng khoa CS
MATCH (d:Department {deptID: "CS"}) RETURN d.dean;

// 11. Liệt kê tất cả các khóa học của CS và IE
MATCH (c:Course) -[:BELONGS_TO]->(d:Department {deptID: "CS"})
MATCH (c2:Course)-[:BELONGS_TO]->(d2:Department {deptID: "IE"})
RETURN c, c2;


MATCH (c:Course)-[:BELONGS_TO]->(d: Department) WHERE d.deptID="CS" OR d.deptID="IE" RETURN c;

// 12. Liệt kê danh sách các tên của các sinh viên đăng ký học khóa học CS101
MATCH (s:Student) - [:ENROLLED] -> (c:Course {courseID:"CS101"}) RETURN s.name;


//13.1 Tổng số sinh viên đăng ký học của mỗi khoa
OPTIONAL MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> (d:Department)
RETURN d.deptID, count(s) as totalStudent //count(s) : đếm số lượng sinh viên

//13.2. Tổng số sinh viên đăng ký học của mỗi khoa (hiển thị những khoa không có sinh viên)
MATCH (d:Department) 
OPTIONAL MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> (d) 
RETURN d.deptID, count(s) as totalStudent

// 14. Tổng số sinh viên đăng ký học của mỗi khoa, kết quả sắp xếp theo mã khoa (tăng dần)
MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> (d:Department)
RETURN d.deptID, count(s) as totalStudent ORDER BY d.deptID

MATCH (d:Department) OPTIONAL MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> (d) RETURN d.deptID, count(s) as totalStudent ORDER BY d.deptID

// 14.2 Tổng số sinh viên đăng ký học của mỗi khoa, kết quả sắp xếp theo số lượng sinh viên giảm dần
MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> (d:Department) RETURN d.deptID, count(s) as totalStudent ORDER BY totalStudent DESC

// 15. Tổng số sinh viên đăng ký học của mỗi khoa, kết quả sắp xếp theo số sinh viên
MATCH (d:Department) OPTIONAL MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> (d) RETURN d.deptID, count(s) as totalStudent ORDER BY totalStudent DESC

//16. Liệt kê danh sách tên của các trưởng khoa mà các khoa này không có sinh viên đăng ký học
MATCH (d:Department) //lấy tất cả các khoa
OPTIONAL MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> (d) //lấy tất cả các sinh viên đăng ký học của các khoa trên 
WITH d, count(s) as totalStudent //WITH : dùng để chuyển từ một phần của câu lệnh truy vấn sang phần tiếp theo
WHERE totalStudent = 0 
RETURN d.dean 

// 17. Danh sách khoa có số sinh viên đăng ký học nhiều nhất


MATCH (d:Department) 
OPTIONAL  MATCH (s:Student) - [:ENROLLED]-> (c:Course) - [:BELONGS_TO] -> (d)
WITH d.deptID as department_id, count(s) AS totalStudents
WITH max(totalStudents) as maxStudents, collect({deptID : department_id,total: totalStudents}) as temp
UNWIND temp AS t
WITH maxStudents, t
WHERE t.total = maxStudents
RETURN  t.deptID  AS department_id


MATCH (d:Department) 
OPTIONAL  MATCH (s:Student) - [:ENROLLED]-> (c:Course) - [:BELONGS_TO] -> (d)
WITH d as department, count(s) AS totalStudents
WITH max(totalStudents) as maxStudents, collect({khoa : department,total: totalStudents}) as temp
UNWIND temp AS t
WITH maxStudents, t
WHERE t.total = maxStudents
RETURN t

// 18. Danh sách sinh viên có gpa >= 3.2, kết quả sắp xếp giảm dần theo gpa
MATCH (s:Student)
WHERE s.gpa >= 3.2
RETURN s ORDER BY s.gpa DESC