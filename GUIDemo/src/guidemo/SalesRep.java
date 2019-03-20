/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guidemo;

/**
 *
 * @author Ronnie Joubert
 */
public class SalesRep 
{
    private String repID;
    private String fName;
    private String lName;
    private String officeSold;
    private String booksSold;
    private String paperSold;
    private double totalSales;
    private String salesDistrict;
    private String contactMethod;
    private boolean contactPhone;
    private boolean contactEmail;
    private boolean contactVisit;

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    /**
     * @return the repID
     */
    public String getRepID()
    {
        return repID;
    }

    /**
     * @param repID the repID to set
     */
    public void setRepID(String repID)
    {
        this.repID = repID;
    }

    /**
     * @return the fName
     */
    public String getfName()
    {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName)
    {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName()
    {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName)
    {
        this.lName = lName;
    }

    /**
     * @return the officeSold
     */
    public String getOfficeSold()
    {
        return officeSold;
    }

    /**
     * @param officeSold the officeSold to set
     */
    public void setOfficeSold(String officeSold)
    {
        this.officeSold = officeSold;
    }

    /**
     * @return the booksSold
     */
    public String getBooksSold()
    {
        return booksSold;
    }

    /**
     * @param booksSold the booksSold to set
     */
    public void setBooksSold(String booksSold)
    {
        this.booksSold = booksSold;
    }

    /**
     * @return the paperSold
     */
    public String getPaperSold()
    {
        return paperSold;
    }

    /**
     * @param paperSold the paperSold to set
     */
    public void setPaperSold(String paperSold)
    {
        this.paperSold = paperSold;
    }
    
    /**
     * @return the totalSales
     */
    public double getTotalSales()
    {
        return totalSales;
    }

    /**
     * @param totalSales the totalSales to set
     */
    public void setTotalSales(double totalSales)
    {
        this.totalSales = totalSales;
    }

    /**
     * @return the salesDistrict
     */
    public String getSalesDistrict()
    {
        return salesDistrict;
    }

    /**
     * @param salesDistrict the salesDistrict to set
     */
    public void setSalesDistrict(String salesDistrict)
    {
        this.salesDistrict = salesDistrict;
    }
    
    /**
     * @return the contactMethod
     */
    public String getContactMethod()
    {
        return contactMethod;
    }

    /**
     * @param contactMethod the contactMethod to set
     */
    public void setContactMethod(String contactMethod)
    {
        this.contactMethod = contactMethod;
    }

    /**
     * @return the contactPhone
     */
    public boolean isContactPhone()
    {
        return contactPhone;
    }

    /**
     * @param contactPhone the contactPhone to set
     */
    public void setContactPhone(boolean contactPhone)
    {
        this.contactPhone = contactPhone;
    }

    /**
     * @return the contactEmail
     */
    public boolean isContactEmail()
    {
        return contactEmail;
    }

    /**
     * @param contactEmail the contactEmail to set
     */
    public void setContactEmail(boolean contactEmail)
    {
        this.contactEmail = contactEmail;
    }

    /**
     * @return the contactVisit
     */
    public boolean isContactVisit()
    {
        return contactVisit;
    }

    /**
     * @param contactVisit the contactVisit to set
     */
    public void setContactVisit(boolean contactVisit)
    {
        this.contactVisit = contactVisit;
    }
    // </editor-fold>
    
    public SalesRep()
    {
        
    }
    
    public SalesRep (String rID, String fN, String lN, String oS, String bS, String pS, String sD, String cM)
    {
        repID = rID;
        fName = fN;
        lName = lN;
        officeSold = oS;
        booksSold = bS;
        paperSold = pS;
        salesDistrict = sD;
        contactMethod = cM;
    }
    
    //This sets contact info as a String.  
    public String setContact()
    {
        String contactInfo = "-";
        
        if (contactPhone && !contactEmail && !contactVisit)
        {
            contactInfo = "Phone";
        }
        if (contactEmail && !contactPhone && !contactVisit)
        {
            contactInfo = "Email";
        }
        if (contactVisit && !contactPhone && !contactEmail)
        {
            contactInfo = "Visit";
        }
        if (contactPhone && contactEmail && !contactVisit)
        {
            contactInfo = "Phone/Email";
        }
        if (contactPhone && contactVisit && !contactEmail)
        {
            contactInfo = "Phone/Visit";
        }
        if (contactEmail && contactVisit && !contactPhone)
        {
            contactInfo = "Email/Visit";
        }
        if (contactPhone && contactEmail && contactVisit)
        {
            contactInfo = "Phone/Email/Visit";
        }
        
        return contactInfo;
    }

    @Override
    public String toString() //Format data
    {
        return String.format("%s\n %s\n %s\n %s\n %s\n %s\n %s\n %s\n \n", 
                getRepID(), getfName(), getlName(), getOfficeSold(), getBooksSold(), getPaperSold(),  getSalesDistrict(), getContactMethod());
    }

    
}
