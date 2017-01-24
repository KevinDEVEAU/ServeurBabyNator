package com.babynator.restserver;

public class BabyNatorUser {
	private int id;
    private String username;
    private int age;

    public BabyNatorUser() { }

    public BabyNatorUser(int id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
    
    /// GETTERS & SETTERS ///
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
	public String toString() {
		return "BabyNatorUser [id=" + id + ", username=" + username + ", age=" + age + "]";
	}

	public int getAge() {
        return this.age;
    }
}
