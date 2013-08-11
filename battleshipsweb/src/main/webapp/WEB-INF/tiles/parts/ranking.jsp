
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    
    #rankingPart {
        
        padding: 5px 5px 5px 5px;
        background-color: white;
        border: 1px solid black;
        -moz-box-sizing: border-box;
        
    }
    
    #rankingList {
        
        padding: 0px;
        list-style-position: inside
    }
    
    #rankingList .userDet:nth-child(even) {
        
        background-color: #FF4D4D;
    }
    
    #rankingList .userDet:nth-child(odd) {
        
        background-color: #33D6FF;
    }
    
</style>

<div id="rankingPart">
    
    <h1 style="margin-top: 0px">Ranking of all players</h1>
    
    <ol id="rankingList" type="I">
        <c:forEach items="${ranking}" var="user">
        
            <div class="userDet">
                <c:if test="${user.hasImage}">
                    <img src="./images/${user.username}.image" style="float:left; width: 100px; height: 100px;"/>
                </c:if>
                <c:if test="${!user.hasImage}">
                    <img src="./images/scout.png" style="float:left; width: 100px; height: 100px;"/>
                </c:if>
                <li style="margin-left: 0px;"><span style="font-weight: bold">${user.username}</span></li>
                <ul>
                    
                    <li>Wins: ${user.wins}</li>
                    <li>Losses: ${user.losses}</li>
                    <li>Total hits: ${user.totalHits}</li>
                    <li>Total misses: ${user.totalMisses}</li>
                    
                </ul>
            </div>
            
        </c:forEach>
    </ol>
    
</div>