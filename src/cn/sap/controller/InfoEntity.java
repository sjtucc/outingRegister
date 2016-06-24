package cn.sap.controller;

public class InfoEntity {
	private String my_id;
	 private String my_name;
	
	private String cellphone;
	 private String my_card;
	 private String partner_name;
	 private String partner_card;
	 private String kid_name;
	 private String kid_card;
	 private String room_type;
	 private String room_mate;
	 private String time;
	public InfoEntity(String my_id, String my_name,String cellphone, String my_card,
			String partner_name, String partner_card, String kid_name,
			String kid_card, String room_type, String room_mate, String time) {

		this.my_id = my_id;
		this.my_name = my_name;
		this.cellphone = cellphone;
		this.my_card = my_card;
		this.partner_name = partner_name;
		this.partner_card = partner_card;
		this.kid_name = kid_name;
		this.kid_card = kid_card;
		this.room_type = room_type;
		this.room_mate = room_mate;
		this.time = time;
	}
	 public String getCellphone() {
			return cellphone;
		}
		public void setCellphone(String cellphone) {
			this.cellphone = cellphone;
		}
	public String getMy_id() {
		return my_id;
	}
	public void setMy_id(String my_id) {
		this.my_id = my_id;
	}
	public String getMy_name() {
		return my_name;
	}
	public void setMy_name(String my_name) {
		this.my_name = my_name;
	}
	public String getMy_card() {
		return my_card;
	}
	public void setMy_card(String my_card) {
		this.my_card = my_card;
	}
	public String getPartner_name() {
		return partner_name;
	}
	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}
	public String getPartner_card() {
		return partner_card;
	}
	public void setPartner_card(String partner_card) {
		this.partner_card = partner_card;
	}
	public String getKid_name() {
		return kid_name;
	}
	public void setKid_name(String kid_name) {
		this.kid_name = kid_name;
	}
	public String getKid_card() {
		return kid_card;
	}
	public void setKid_card(String kid_card) {
		this.kid_card = kid_card;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getRoom_mate() {
		return room_mate;
	}
	public void setRoom_mate(String room_mate) {
		this.room_mate = room_mate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
