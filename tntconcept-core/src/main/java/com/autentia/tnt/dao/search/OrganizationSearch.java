/**
 * TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
 * Copyright (C) 2007 Autentia Real Bussiness Solution S.L.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */














package com.autentia.tnt.dao.search;

import java.util.*;

import com.autentia.tnt.businessobject.*;
import com.autentia.tnt.dao.*;

/**
 * Class to search for Organization objects
 * @author stajanov code generator
 */
public class OrganizationSearch extends SearchCriteria 
{
/* generated by stajanov (do not edit/delete) */















  @Override
  public String getHQL() {
    StringBuilder ret = new StringBuilder();
    int iArgNum = 0;
            
    
  
        
    if( isNameSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getName()==null ){
	ret.append( "name is NULL" );
      } else {
	ret.append( "name like :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isDocumentNumberSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getDocumentNumber()==null ){
	ret.append( "documentNumber is NULL" );
      } else {
	ret.append( "documentNumber = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isStreetSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getStreet()==null ){
	ret.append( "street is NULL" );
      } else {
	ret.append( "street = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isNumberSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getNumber()==null ){
	ret.append( "number is NULL" );
      } else {
	ret.append( "number = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isLocatorSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getLocator()==null ){
	ret.append( "locator is NULL" );
      } else {
	ret.append( "locator = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isPostalCodeSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getPostalCode()==null ){
	ret.append( "postalCode is NULL" );
      } else {
	ret.append( "postalCode = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isCitySet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getCity()==null ){
	ret.append( "city is NULL" );
      } else {
	ret.append( "city = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isStateSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getState()==null ){
	ret.append( "state is NULL" );
      } else {
	ret.append( "state = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isCountrySet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getCountry()==null ){
	ret.append( "country is NULL" );
      } else {
	ret.append( "country = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isPhoneSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getPhone()==null ){
	ret.append( "phone is NULL" );
      } else {
	ret.append( "phone = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isFaxSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getFax()==null ){
	ret.append( "fax is NULL" );
      } else {
	ret.append( "fax = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isEmailSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getEmail()==null ){
	ret.append( "email is NULL" );
      } else {
	ret.append( "email = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isWebsiteSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getWebsite()==null ){
	ret.append( "website is NULL" );
      } else {
	ret.append( "website = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isFtpsiteSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getFtpsite()==null ){
	ret.append( "ftpsite is NULL" );
      } else {
	ret.append( "ftpsite = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isNotesSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getNotes()==null ){
	ret.append( "notes is NULL" );
      } else {
	ret.append( "notes = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isOwnerIdSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getOwnerId()==null ){
	ret.append( "ownerId is NULL" );
      } else {
	ret.append( "ownerId = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isDepartmentIdSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getDepartmentId()==null ){
	ret.append( "departmentId is NULL" );
      } else {
	ret.append( "departmentId = :arg"+(iArgNum++) );
      }
    }

              
    
      if( isStartInsertDateSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( startInsertDate == null ){
        ret.append( "insertDate=:arg"+(iArgNum++) );
      } else {
        ret.append( "insertDate>=:arg"+(iArgNum++) );
      }
    }
    if( isEndInsertDateSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( endInsertDate == null ){
        ret.append( "insertDate=:arg"+(iArgNum++) );
      } else {
        ret.append( "insertDate<=:arg"+(iArgNum++) );
      }
    }

              
    
      if( isStartUpdateDateSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( startUpdateDate == null ){
        ret.append( "updateDate=:arg"+(iArgNum++) );
      } else {
        ret.append( "updateDate>=:arg"+(iArgNum++) );
      }
    }
    if( isEndUpdateDateSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( endUpdateDate == null ){
        ret.append( "updateDate=:arg"+(iArgNum++) );
      } else {
        ret.append( "updateDate<=:arg"+(iArgNum++) );
      }
    }

                  
    
  
        
    if( isTypeSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getType()==null ){
	ret.append( "type is NULL" );
      } else {
	ret.append( "type = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isCategorySet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getCategory()==null ){
	ret.append( "category is NULL" );
      } else {
	ret.append( "category = :arg"+(iArgNum++) );
      }
    }

    
    if( isEvaluationCriteriaSet() ){
        ret.append( (ret.length()==0) ? "WHERE " : " AND " );
        if( getEvaluationCriteria()==null ){
  	ret.append( "evaluationCriteria is NULL" );
        } else {
  	ret.append( "evaluationCriteria = :arg"+(iArgNum++) );
        }
      }
              
    
  
        
    if( isProvinceSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getProvince()==null ){
	ret.append( "province is NULL" );
      } else {
	ret.append( "province = :arg"+(iArgNum++) );
      }
    }

                  customGetHQL(ret,iArgNum);
    return ret.toString();
  }

  @Override
  public Object[] getArguments(){
    ArrayList<Object> ret = new ArrayList<Object>();
            
  
      if( isNameSet() && getName()!=null ){
        ret.add( name );
    }

              
  
      if( isDocumentNumberSet() && getDocumentNumber()!=null ){
        ret.add(documentNumber);
    }

              
  
      if( isStreetSet() && getStreet()!=null ){
        ret.add( street );
    }

              
  
      if( isNumberSet() && getNumber()!=null ){
        ret.add( number );
    }

              
  
      if( isLocatorSet() && getLocator()!=null ){
        ret.add( locator );
    }

              
  
      if( isPostalCodeSet() && getPostalCode()!=null ){
        ret.add( postalCode );
    }

              
  
      if( isCitySet() && getCity()!=null ){
        ret.add( city );
    }

              
  
      if( isStateSet() && getState()!=null ){
        ret.add( state );
    }

              
  
      if( isCountrySet() && getCountry()!=null ){
        ret.add( country );
    }

              
  
      if( isPhoneSet() && getPhone()!=null ){
        ret.add( phone );
    }

              
  
      if( isFaxSet() && getFax()!=null ){
        ret.add( fax );
    }

              
  
      if( isEmailSet() && getEmail()!=null ){
        ret.add( email );
    }

              
  
      if( isWebsiteSet() && getWebsite()!=null ){
        ret.add( website );
    }

              
  
      if( isFtpsiteSet() && getFtpsite()!=null ){
        ret.add( ftpsite );
    }

              
  
      if( isNotesSet() && getNotes()!=null ){
        ret.add( notes );
    }

              
  
      if( isOwnerIdSet() && getOwnerId()!=null ){
        ret.add( ownerId );
    }

              
  
      if( isDepartmentIdSet() && getDepartmentId()!=null ){
        ret.add( departmentId );
    }

              
  
      if( isStartInsertDateSet() ){
        ret.add( startInsertDate );
    }
    if( isEndInsertDateSet() ){
        ret.add( endInsertDate );
    }

              
  
      if( isStartUpdateDateSet() ){
        ret.add( startUpdateDate );
    }
    if( isEndUpdateDateSet() ){
        ret.add( endUpdateDate );
    }

                  
  
      if( isTypeSet() && getType()!=null ){
        ret.add( type );
    }

              
  
      if( isCategorySet() && getCategory()!=null ){
        ret.add( category );
    }

      if( isEvaluationCriteriaSet() && getEvaluationCriteria()!=null ){
          ret.add( evaluationCriteria );
      }        
  
      if( isProvinceSet() && getProvince()!=null ){
        ret.add( province );
    }

                  customGetArguments(ret);
    return ret.toArray();
  }

  @Override
  public void reset(){
            
  
      unsetName();
  
              
  
      unsetDocumentNumber();
  
              
  
      unsetStreet();
  
              
  
      unsetNumber();
  
              
  
      unsetLocator();
  
              
  
      unsetPostalCode();
  
              
  
      unsetCity();
  
              
  
      unsetState();
  
              
  
      unsetCountry();
  
              
  
      unsetPhone();
  
              
  
      unsetFax();
  
              
  
      unsetEmail();
  
              
  
      unsetWebsite();
  
              
  
      unsetFtpsite();
  
              
  
      unsetNotes();
  
              
  
      unsetOwnerId();
  
              
  
      unsetDepartmentId();
  
              
  
      unsetStartInsertDate();
    unsetEndInsertDate();

              
  
      unsetStartUpdateDate();
    unsetEndUpdateDate();

                  
  
      unsetType();
  
              
  
      unsetCategory();
  
              
  
      unsetProvince();
  
      unsetEvaluationCriteria();
      
                  customReset();
  }
    
  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder();
    ret.append("OrganizationSearch{");
            
  
  
          if( isNameSet() ){
          ret.append( "(name" );
          ret.append( "="+name );
          ret.append( ")" );
      }

    
              
  
  
          if( isDocumentNumberSet() ){
          ret.append( "(documentNumber" );
          ret.append( "="+ documentNumber);
          ret.append( ")" );
      }

    
              
  
  
          if( isStreetSet() ){
          ret.append( "(street" );
          ret.append( "="+street );
          ret.append( ")" );
      }

    
              
  
  
          if( isNumberSet() ){
          ret.append( "(number" );
          ret.append( "="+number );
          ret.append( ")" );
      }

    
              
  
  
          if( isLocatorSet() ){
          ret.append( "(locator" );
          ret.append( "="+locator );
          ret.append( ")" );
      }

    
              
  
  
          if( isPostalCodeSet() ){
          ret.append( "(postalCode" );
          ret.append( "="+postalCode );
          ret.append( ")" );
      }

    
              
  
  
          if( isCitySet() ){
          ret.append( "(city" );
          ret.append( "="+city );
          ret.append( ")" );
      }

    
              
  
  
          if( isStateSet() ){
          ret.append( "(state" );
          ret.append( "="+state );
          ret.append( ")" );
      }

    
              
  
  
          if( isCountrySet() ){
          ret.append( "(country" );
          ret.append( "="+country );
          ret.append( ")" );
      }

    
              
  
  
          if( isPhoneSet() ){
          ret.append( "(phone" );
          ret.append( "="+phone );
          ret.append( ")" );
      }

    
              
  
  
          if( isFaxSet() ){
          ret.append( "(fax" );
          ret.append( "="+fax );
          ret.append( ")" );
      }

    
              
  
  
          if( isEmailSet() ){
          ret.append( "(email" );
          ret.append( "="+email );
          ret.append( ")" );
      }

    
              
  
  
          if( isWebsiteSet() ){
          ret.append( "(website" );
          ret.append( "="+website );
          ret.append( ")" );
      }

    
              
  
  
          if( isFtpsiteSet() ){
          ret.append( "(ftpsite" );
          ret.append( "="+ftpsite );
          ret.append( ")" );
      }

    
              
  
  
          if( isNotesSet() ){
          ret.append( "(notes" );
          ret.append( "="+notes );
          ret.append( ")" );
      }

    
              
  
  
          if( isOwnerIdSet() ){
          ret.append( "(ownerId" );
          ret.append( "="+ownerId );
          ret.append( ")" );
      }

    
              
  
  
          if( isDepartmentIdSet() ){
          ret.append( "(departmentId" );
          ret.append( "="+departmentId );
          ret.append( ")" );
      }

    
              
  
  
    if( isStartInsertDateSet() ){
        ret.append( "(startInsertDate" );
        ret.append( "="+startInsertDate );
        ret.append( ")" );
    }
    if( isEndInsertDateSet() ){
        ret.append( "(endInsertDate" );
        ret.append( "="+endInsertDate );
        ret.append( ")" );
    }

              
  
  
    if( isStartUpdateDateSet() ){
        ret.append( "(startUpdateDate" );
        ret.append( "="+startUpdateDate );
        ret.append( ")" );
    }
    if( isEndUpdateDateSet() ){
        ret.append( "(endUpdateDate" );
        ret.append( "="+endUpdateDate );
        ret.append( ")" );
    }

                  
  
  
          if( isTypeSet() ){
          ret.append( "(type" );
          ret.append( "="+type );
          ret.append( ")" );
      }

    
              
  
  
          if( isCategorySet() ){
          ret.append( "(category" );
          ret.append( "="+category );
          ret.append( ")" );
      }

    
              
  
  
          if( isProvinceSet() ){
          ret.append( "(province" );
          ret.append( "="+province );
          ret.append( ")" );
      }

    
                  customToString(ret);
    ret.append("}");
    return ret.toString();
  }

  // Getters and setters
        
  
  
    
    
    public boolean isNameSet(){
        return nameSet;
    }
    public String getName(){
        return name;
    }
    public void setName( String name ){
        this.name = name;
        this.nameSet = true;
    }
    public void unsetName(){
        this.nameSet = false;
    }
          
  
  
    
    
    public boolean isDocumentNumberSet(){
        return documentNumberSet;
    }
    public String getDocumentNumber(){
        return documentNumber;
    }
    public void setDocumentNumber(String documentNumber){
        this.documentNumber = documentNumber;
        this.documentNumberSet = true;
    }
    public void unsetDocumentNumber(){
        this.documentNumberSet = false;
    }
          
  
  
    
    
    public boolean isStreetSet(){
        return streetSet;
    }
    public String getStreet(){
        return street;
    }
    public void setStreet( String street ){
        this.street = street;
        this.streetSet = true;
    }
    public void unsetStreet(){
        this.streetSet = false;
    }
          
  
  
    
    
    public boolean isNumberSet(){
        return numberSet;
    }
    public String getNumber(){
        return number;
    }
    public void setNumber( String number ){
        this.number = number;
        this.numberSet = true;
    }
    public void unsetNumber(){
        this.numberSet = false;
    }
          
  
  
    
    
    public boolean isLocatorSet(){
        return locatorSet;
    }
    public String getLocator(){
        return locator;
    }
    public void setLocator( String locator ){
        this.locator = locator;
        this.locatorSet = true;
    }
    public void unsetLocator(){
        this.locatorSet = false;
    }
          
  
  
    
    
    public boolean isPostalCodeSet(){
        return postalCodeSet;
    }
    public String getPostalCode(){
        return postalCode;
    }
    public void setPostalCode( String postalCode ){
        this.postalCode = postalCode;
        this.postalCodeSet = true;
    }
    public void unsetPostalCode(){
        this.postalCodeSet = false;
    }
          
  
  
    
    
    public boolean isCitySet(){
        return citySet;
    }
    public String getCity(){
        return city;
    }
    public void setCity( String city ){
        this.city = city;
        this.citySet = true;
    }
    public void unsetCity(){
        this.citySet = false;
    }
          
  
  
    
    
    public boolean isStateSet(){
        return stateSet;
    }
    public String getState(){
        return state;
    }
    public void setState( String state ){
        this.state = state;
        this.stateSet = true;
    }
    public void unsetState(){
        this.stateSet = false;
    }
          
  
  
    
    
    public boolean isCountrySet(){
        return countrySet;
    }
    public Country getCountry(){
        return country;
    }
    public void setCountry(Country country){
        this.country = country;
        this.countrySet = true;
    }
    public void unsetCountry(){
        this.countrySet = false;
    }
          
  
  
    
    
    public boolean isPhoneSet(){
        return phoneSet;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone( String phone ){
        this.phone = phone;
        this.phoneSet = true;
    }
    public void unsetPhone(){
        this.phoneSet = false;
    }
          
  
  
    
    
    public boolean isFaxSet(){
        return faxSet;
    }
    public String getFax(){
        return fax;
    }
    public void setFax( String fax ){
        this.fax = fax;
        this.faxSet = true;
    }
    public void unsetFax(){
        this.faxSet = false;
    }
          
  
  
    
    
    public boolean isEmailSet(){
        return emailSet;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail( String email ){
        this.email = email;
        this.emailSet = true;
    }
    public void unsetEmail(){
        this.emailSet = false;
    }
          
  
  
    
    
    public boolean isWebsiteSet(){
        return websiteSet;
    }
    public String getWebsite(){
        return website;
    }
    public void setWebsite( String website ){
        this.website = website;
        this.websiteSet = true;
    }
    public void unsetWebsite(){
        this.websiteSet = false;
    }
          
  
  
    
    
    public boolean isFtpsiteSet(){
        return ftpsiteSet;
    }
    public String getFtpsite(){
        return ftpsite;
    }
    public void setFtpsite( String ftpsite ){
        this.ftpsite = ftpsite;
        this.ftpsiteSet = true;
    }
    public void unsetFtpsite(){
        this.ftpsiteSet = false;
    }
          
  
  
    
    
    public boolean isNotesSet(){
        return notesSet;
    }
    public String getNotes(){
        return notes;
    }
    public void setNotes( String notes ){
        this.notes = notes;
        this.notesSet = true;
    }
    public void unsetNotes(){
        this.notesSet = false;
    }
          
  
  
    
    
    public boolean isOwnerIdSet(){
        return ownerIdSet;
    }
    public Integer getOwnerId(){
        return ownerId;
    }
    public void setOwnerId( Integer ownerId ){
        this.ownerId = ownerId;
        this.ownerIdSet = true;
    }
    public void unsetOwnerId(){
        this.ownerIdSet = false;
    }
          
  
  
    
    
    public boolean isDepartmentIdSet(){
        return departmentIdSet;
    }
    public Integer getDepartmentId(){
        return departmentId;
    }
    public void setDepartmentId( Integer departmentId ){
        this.departmentId = departmentId;
        this.departmentIdSet = true;
    }
    public void unsetDepartmentId(){
        this.departmentIdSet = false;
    }
          
  
  
    public boolean isStartInsertDateSet(){
        return startInsertDateSet;
    }
    public Date getStartInsertDate(){
        return startInsertDate;
    }
    public void setStartInsertDate( Date startInsertDate ){
        this.startInsertDate = startInsertDate;
        this.startInsertDateSet = true;
    }
    public void unsetStartInsertDate(){
        this.startInsertDateSet = false;
    }
    public boolean isEndInsertDateSet(){
        return endInsertDateSet;
    }
    public Date getEndInsertDate(){
        return endInsertDate;
    }
    public void setEndInsertDate( Date endInsertDate ){
        this.endInsertDate = endInsertDate;
        this.endInsertDateSet = true;
    }
    public void unsetEndInsertDate(){
        this.endInsertDateSet = false;
    }

          
  
  
    public boolean isStartUpdateDateSet(){
        return startUpdateDateSet;
    }
    public Date getStartUpdateDate(){
        return startUpdateDate;
    }
    public void setStartUpdateDate( Date startUpdateDate ){
        this.startUpdateDate = startUpdateDate;
        this.startUpdateDateSet = true;
    }
    public void unsetStartUpdateDate(){
        this.startUpdateDateSet = false;
    }
    public boolean isEndUpdateDateSet(){
        return endUpdateDateSet;
    }
    public Date getEndUpdateDate(){
        return endUpdateDate;
    }
    public void setEndUpdateDate( Date endUpdateDate ){
        this.endUpdateDate = endUpdateDate;
        this.endUpdateDateSet = true;
    }
    public void unsetEndUpdateDate(){
        this.endUpdateDateSet = false;
    }

            
  
  
    
    
    public boolean isTypeSet(){
        return typeSet;
    }
    public OrganizationType getType(){
        return type;
    }
    public void setType( OrganizationType type ){
        this.type = type;
        this.typeSet = true;
    }
    public void unsetType(){
        this.typeSet = false;
    }
          
  
  
    
    
    public boolean isCategorySet(){
        return categorySet;
    }
    public OrganizationISOCategory getCategory(){
        return category;
    }
    public void setCategory( OrganizationISOCategory category ){
        this.category = category;
        this.categorySet = true;
    }
    public void unsetCategory(){
        this.categorySet = false;
       
    }
    
    
    
          
    public boolean isEvaluationCriteriaSet(){
        return evaluationCriteriaSet;
    }
    public EvaluationCriteria getEvaluationCriteria(){
        return evaluationCriteria;
    }
    public void setEvaluationCriteria( EvaluationCriteria evaluationCriteria ){
        this.evaluationCriteria = evaluationCriteria;
        this.evaluationCriteriaSet = true;
    }
    public void unsetEvaluationCriteria(){
        this.evaluationCriteriaSet = false;
    }
  
    
    
    public boolean isProvinceSet(){
        return provinceSet;
    }
    public Province getProvince(){
        return province;
    }
    public void setProvince( Province province ){
        this.province = province;
        this.provinceSet = true;
    }
    public void unsetProvince(){
        this.provinceSet = false;
    }
        
  // Fields
        
  
      private boolean nameSet;
        private String name;

          
  
      private boolean documentNumberSet;
        private String documentNumber;

          
  
      private boolean streetSet;
        private String street;

          
  
      private boolean numberSet;
        private String number;

          
  
      private boolean locatorSet;
        private String locator;

          
  
      private boolean postalCodeSet;
        private String postalCode;

          
  
      private boolean citySet;
        private String city;

          
  
      private boolean stateSet;
        private String state;

          
  
      private boolean countrySet;
        private Country country;

          
  
      private boolean phoneSet;
        private String phone;

          
  
      private boolean faxSet;
        private String fax;

          
  
      private boolean emailSet;
        private String email;

          
  
      private boolean websiteSet;
        private String website;

          
  
      private boolean ftpsiteSet;
        private String ftpsite;

          
  
      private boolean notesSet;
        private String notes;

          
  
      private boolean ownerIdSet;
        private Integer ownerId;

          
  
      private boolean departmentIdSet;
        private Integer departmentId;

          
  
      private boolean startInsertDateSet;
        private Date startInsertDate;
    private boolean endInsertDateSet;
        private Date endInsertDate;

          
  
      private boolean startUpdateDateSet;
        private Date startUpdateDate;
    private boolean endUpdateDateSet;
        private Date endUpdateDate;

            
  
      private boolean typeSet;
        private OrganizationType type;
  
          
  
      private boolean categorySet;
        private OrganizationISOCategory category;
  
      private EvaluationCriteria evaluationCriteria;    
      private boolean evaluationCriteriaSet;
  
      private boolean provinceSet;
        private Province province;
  
        
  // Returns if there are a search condition active
  public boolean isSearchActive() {
    return customIsSearchActive()||nameSet|| documentNumberSet ||streetSet||numberSet||locatorSet||postalCodeSet||citySet||stateSet||countrySet||phoneSet||faxSet||emailSet||websiteSet||ftpsiteSet||notesSet||ownerIdSet||departmentIdSet||startInsertDateSet||endInsertDateSet||startUpdateDateSet||endUpdateDateSet||typeSet||categorySet||provinceSet||evaluationCriteriaSet;
  }


/* generated by stajanov (do not edit/delete) */

	private void customGetHQL(StringBuilder ret, int iArgNum)
	{
	}

	private boolean customIsSearchActive()
	{
		return false;
	}

	private void customToString(StringBuilder ret)
	{
	}

	private void customReset()
	{
	}

	private void customGetArguments(ArrayList ret)
	{
	}
}
