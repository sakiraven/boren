package dao;

public interface ICommonCURD {
	public static final String DEL = "delete";
	public static final String SAVE = "save";
	public static final String UPDATE = "update";
	public void modifyObj(Object obj,String type);
}
