package myGame;

public class Cell {
	
	private char name;
	private boolean flag;
	private boolean mine;
	private boolean open;
	
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Cell [name=" + name + ", flag=" + flag + ", mine=" + mine
				+ ", open=" + open + "]";
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean isMine() {
		return mine;
	}
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	

}
