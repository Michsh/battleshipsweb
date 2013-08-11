
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
    
    #registrationForm {
        
        background-color: white;
        border: 1px solid black;
        -moz-box-sizing: border-box;
        width: 100%;
        height: 100%;
    }
    
    td:nth-child(1) {
        
        float: right;
    }
    
    td {
        
        margin: 10px 10px 10px 10px;
        
    }
    
    .longer {
        
        width: 300px;
    }
    
</style>

<div id="registrationForm" style="padding: 13%;">
    
    <c:if test="${not empty param.registration_error}">
        <div class="errorblock">
            REGISTRATION ERROR<br/>
            Reason: ${REGISTRATION_ERROR}<br/>
        </div>
    </c:if>
    
    <form method="POST" enctype="multipart/form-data">
        
        <table>
            
            <tr>
                
                <td>Username: </td>
                <td><input class="longer" type="text" name="regusername"/></td>
                
            </tr>
            
            <tr>
                
                <td>Password: </td>
                <td><input class="longer" type="password" name="regpassword" id="psw"/></td>
                
            </tr>
            
            <tr>
                
                <td>Repeat password: </td>
                <td><input class="longer" type="password" name="regrpassword" id="rp_psw"/></td>
                
            </tr>
            
            <tr>
                
                <td>Your avatar: </td>
                <td><input type="file" name="regavatar"/></td>
                
            </tr>
            
            <tr>
                
                <td><input type="submit" value="Register"></td>
                
            </tr>
            
        </table>
        
    </form>
    
</div>