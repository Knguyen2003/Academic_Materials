package entity;




public class Department {
    private String departmentID;
    private String name;
    private String dean;
    private String biulding;
    private int room;
    
    public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String departmentID, String name, String dean, String biulding, int room) {
		
		this.departmentID = departmentID;
		this.name = name;
		this.dean = dean;
		this.biulding = biulding;
		this.room = room;
	}

	public Department(String departmentID) {
		
		this.departmentID = departmentID;
	}
	
	
	

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDean() {
		return dean;
	}

	public void setDean(String dean) {
		this.dean = dean;
	}

	public String getBiulding() {
		return biulding;
	}

	public void setBiulding(String biulding) {
		this.biulding = biulding;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", name=" + name + ", dean=" + dean + ", biulding="
				+ biulding + ", room=" + room + "]";
	}
	
	
	
	
	
    
    
    
}
