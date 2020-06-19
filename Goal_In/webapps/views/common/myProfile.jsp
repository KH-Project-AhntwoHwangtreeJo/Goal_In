<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <aside class="single_sidebar_widget search_widget mx-auto text-center">

                                <div class="form-group">
                                
                                    <div class="input-group mb-3">
                                        <img src="/Goal_In/resources/memberImg/<%= m.getMimage() %>" class="mx-auto text-center rounded-circle" 
                                        style="width : 150px; height : 150px;">
                    
                                    </div>
                                    
                                    <div>
                                    	<p>닉네임 : <%= m.getNickname() %></p><br>
                                    	<p>잔여포인트 : <%= m.getBalance() %></p><br>
                                    	<p>참여중인 골 갯수</p><br>
                                    	
                                    </div>
                                </div>
                        </aside>