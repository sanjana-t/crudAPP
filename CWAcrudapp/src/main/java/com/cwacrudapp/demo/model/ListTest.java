package com.cwacrudapp.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.StringArrayType;


@TypeDefs({
    @TypeDef(
        name = "string-array", 
        typeClass = StringArrayType.class
    )
})

@Entity
@Table(name = "list_test")
public class ListTest {
	
	@Id
	@Column(name="id")
	private Integer id;
//	@Type(type = "string-array")
//	@Column(
//        name = "country_id",
//        columnDefinition="text[]"
//    )
//    private String[] countryId;
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public String[] getCountryId() {
//		return countryId;
//	}
//	public void setCountryId(String[] countryId) {
//		this.countryId = countryId;
//	}



}
