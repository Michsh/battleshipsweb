
<style>
    #signInForm {
        
        padding: 2px 2px 2px 2px;
        background-color: white;
        border: 1px solid black;
        -moz-box-sizing: border-box;
    }
    
    .textInp {
        
        width: 95%;
    }
    
</style>

<div id="signInForm">
    
    <form method="POST" action="j_spring_security_check">
        
        <table>
            
            <tr>
                
                <td>Username: </td>
                
                <td><input name="j_username" type="text" class="textInp" size="15"/></td>
                
            </tr>
            
            <tr>
                
                <td>Password: </td>
                
                <td><input name="j_password" type="password" class="textInp" size="15"/></td>
                
            </tr>
            
            <tr>
                
                <td><input name="commit" type="submit" value="Sign in"/></td>
                
                <td><a href="registration">Register</a></td>
                
            </tr>
            
        </table>
        
    </form>
    
</div>