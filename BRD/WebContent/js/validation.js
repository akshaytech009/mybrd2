function validate() {
    
    //CustomerCode Validation
    var  custcode= document.forms["form"]["Custcode"].value;
	if ((custcode == "")||(cust_code.length>10)) {
        alert("Customer Code Field is Invalid");
        return false;
    }

    //CustomerName Validation
    var  cust_name= document.forms["form"]["Custname"].value;
	if ((cust_name == "")||(cust_name.length>30)) {
        alert("Customer Name Field is Invalid");
        return false;
    }
	
    //CustomerAddress1 Validation
    var  address_1= document.forms["form"]["Custadd1"].value;
	if ((address_1 == "")||(address_1.length>100)) {
        alert("Permanent Address Field is Invalid");
        return false;
    }
	
	//CustomerAddress2 Validation
    var  address_2= document.forms["form"]["Custadd2"].value;
	if ((address_2.length>100)) {
        alert("Current Address Field is Invalid");
        return false;
    }
	
    
    //CustomerPinCode Validation
    var  pin_code= document.forms["form"]["pincode"].value;
	if ((pin_code == "")||(pin_code.length>6)) {
        alert("Pin Code Field is Invalid");
        return false;
    }
	

    //EmailId Validation
    var  email_id= document.forms["form"]["email"].value;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if ((email_id == "")||(email_id.length>100)||(!email_id.match(mailformat))) {
		
        alert("Email Id Field is Invalid");
        return false;
    }

	//ContactNumber Validation
	var  contact_no= document.forms["form"]["contactno"].value;
	if ((contact_no.length>20)) {
        alert("Contact No. Field is Invalid");
        return false;
    }
	
	//PrimaryContactPerson Validation
	var  primary_contact_person= document.forms["form"]["primaryno"].value;
	if ((primary_contact_person=="")||(primary_contact_person.length>100)) {
        alert("Primary Contact Person Field is Invalid");
        return false;
    }
	
	
	//Flag Validation
//	var  activeinactive_flag= document.forms["myForm"]["flag"].value;
//	if ((activeinactive_flag=="")||(activeinactive_flag.length>1)) {
//        alert("Active/Inactive Field is Invalid");
//        return false;
//    }
	
	return true;
} 