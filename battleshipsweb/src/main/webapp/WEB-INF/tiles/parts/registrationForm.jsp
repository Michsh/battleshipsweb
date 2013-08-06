
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
    
    <form method="POST">
        
        <table>
            
            <tr>
                
                <td>Username: </td>
                <td><input class="longer" type="text" name="regUsername"/></td>
                
            </tr>
            
            <tr>
                
                <td>Password: </td>
                <td><input class="longer" type="password" name="regPassword" id="psw"/></td>
                
            </tr>
            
            <tr>
                
                <td>Repeat password: </td>
                <td><input class="longer" type="password" id="rp_psw"/></td>
                
            </tr>
            
            <tr>
                
                <td>Your avatar: </td>
                <td><input type="file" name="regAvatar"/></td>
                
            </tr>
            
            <tr>
                
                <td><input type="submit" value="Register"></td>
                
            </tr>
            
        </table>
        
    </form>
    
</div>