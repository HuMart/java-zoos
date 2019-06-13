package com.lambdaschool.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephone
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long telephoneid;

    private String phonetype;
    private String phonenumber;

    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties("telephones")
    private Zoo zoo;

    public Telephone()
    {
    }

    public Telephone(String phonetype, String phonenumber)
    {
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
    }

    public Telephone(String phonetype)
    {
        this.phonetype = phonetype;
    }

    public long getTelephoneid()
    {
        return telephoneid;
    }

    public void setTelephoneid(long telephoneid)
    {
        this.telephoneid = telephoneid;
    }

    public String getPhonetype()
    {
        return phonetype;
    }

    public void setPhonetype(String phonetype)
    {
        this.phonetype = phonetype;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public Zoo getZoo()
    {
        return zoo;
    }

    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }
}
