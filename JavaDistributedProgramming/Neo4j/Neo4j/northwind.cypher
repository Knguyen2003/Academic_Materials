// 1. Thêm/ xóa/ sửa/ tìm kiếm 


// 2. Tìm các sản phẩm được cung cấp bởi một nhà cung cấp nào đó khi biết tên nhà cung cấp
MATCH (s:Supplier)-[:SUPPLIES]->(p:Product)
WHERE s.companyName = 'Pavlova'
RETURN p

// 3. Tìm danh sách sản phẩm có giá cao nhất.
MATCH (p:Product) 
WITH max(p.unitPrice) as maxPrice 
MATCH (p:Product) WHERE p.unitPrice = maxPrice 
RETURN p

// 4. Thống kê số khách hàng theo từng thành phố (sắp xếp theo số khách hàng / theo city).
// sắp xếp theo số khách hàng
MATCH (c:Customer)
RETURN c.city as city, count(c) as count
ORDER BY count DESC
//sắp xếp theo city
MATCH (c:Customer)
RETURN c.city as city, count(c) as count
ORDER BY c.city DESC

// + getNumberCustomerByCity() : Map<String, Integer>


// 5. Tính tổng tiền của đơn hàng khi biết mã số đơn hàng.
MATCH (o:Order)-[r:ORDERS]->(p:Product) 
where o.orderID="11005"  
RETURN sum(toFloat(r.unitPrice)*r.quantity) as totalAmount

// 6. Đếm số đơn hàng của từng khách hàng.
MATCH (c:Customer)-[p:PURCHASED]->(o:Order)
RETURN c, count(o) as count

// + getOrdersByCustomers() : Map<Customer, Integer>


// 7. Tính tổng số lượng của từng sản phẩm đã bán ra.

MATCH (o:Order)-[r:ORDERS]->(p:Product) 
return p.productName as productName, sum(r.quantity) as totalQuantity

// + getTotalProduct(): Map<String, Integer>

// 8. Dùng text search để tìm kiếm sản phẩm theo tên sản phẩm. 
CREATE FULLTEXT INDEX text_index_pName for (p:Product) on EACH [p.productName]
CALL db.index.fulltext.queryNodes('text_index_pName', $name) YIELD node RETURN node

// 9. Tính tổng tiền của tất cả các hóa đơn trong một ngày nào đó.
MATCH (o:Order)-[r:ORDERS]->(p:Product)
WHERE o.orderDate = "1996-07-04 00:00:00.000"
RETURN sum(toFloat(r.unitPrice) * r.quantity) as totalAmount

// 10. Thống kê tổng tiền hóa đơn theo tháng / năm.

MATCH (o:Order)-[r:ORDERS]->(p:Product) 
WITH replace(o.orderDate, ' ', 'T')  AS formattedDateTime,r
WITH datetime(formattedDateTime) AS dateTime,r
WHERE dateTime.year = 1996 AND dateTime.month = 7
RETURN sum(toFloat(r.unitPrice) * r.quantity) as totalAmount