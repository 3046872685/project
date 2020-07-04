package com.accp.domain;

import java.util.List;

public class Users {
    private Integer id;

    private String lianxiren;

    private String lxdh;

    private String name;

    private String time;

    private String dizhi;

    private String fzr;

    private String swdjh;
    
    private Dztable dz;
    
    private List<Dztable> list;
    

    public Dztable getDz() {
		return dz;
	}

	public void setDz(Dztable dz) {
		this.dz = dz;
	}

	public List<Dztable> getList() {
		return list;
	}

	public void setList(List<Dztable> list) {
		this.list = list;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLianxiren() {
        return lianxiren;
    }

    public void setLianxiren(String lianxiren) {
        this.lianxiren = lianxiren;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getSwdjh() {
        return swdjh;
    }

    public void setSwdjh(String swdjh) {
        this.swdjh = swdjh;
    }
}