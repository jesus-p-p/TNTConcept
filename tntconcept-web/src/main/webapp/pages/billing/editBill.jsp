<%--

    TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
    Copyright (C) 2007 Autentia Real Bussiness Solution S.L.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

--%>

 <%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/inc/tlibs.jsp" %>

<html>
  <head>
    <%@include file="/inc/uiCore.jsp" %>
    <script type="text/javascript">
     function openPDF(id,idOrg) {
     	var account = document.getElementById("bill:account").value;
     	var expiration = document.getElementById("bill:expiration").value;
     	openReportParameters("document/factura.pdf","?id="+id+"&idOrg="+idOrg+"&idAccount="+account+"&expiration="+expiration+"&SUBREPORT_BILLHEADER=factura_subreport&SUBREPORT_BILLFOOTERINFO=footerInfo_subreport&SUBREPORT_BILLFOOTERACCOUNT=account_subreport&SUBREPORT_IVAAPLICADO=iva_aplicado&SUBREPORT_VENCIMIENTO=vencimiento_subreport","");
     }
    
    </script>
  </head>	
  <body>
    
    <!-- editBill.jsp: generated by stajanov code generator -->
    <f:loadBundle basename="com.autentia.tnt.resources.messages" var="msg" />
    <i:location place="editBill" msg="${msg}"/> 
    
    <f:view>
        <%@include file="/inc/header.jsp" %>
      <h:form id="bill" enctype="multipart/form-data">
        
        <%-- Header --%>
        <i:titleBar name="${billBean.number}" msg="${msg}">
          <h:commandLink action="#{billBean.save}"
                         onclick="if(!askSave('#{billBean.id}','#{msg['question.confirmSave']}')) return false;">
            <h:graphicImage title="#{msg.entityActions_save}" value="/img/save.gif" styleClass="titleImg" />
          </h:commandLink>
          <h:commandLink rendered="#{billBean.bill.submitted == 0 }" action="#{billBean.delete}"
                         onclick="if( !confirm('#{msg['question.confirmDelete']}') ) return false;">
            <h:graphicImage title="#{msg.entityActions_delete}" value="/img/delete.gif" styleClass="titleImg" />
          </h:commandLink>
          <h:commandLink action="#{billBean.list}" immediate="true">
            <h:graphicImage title="#{msg.entityActions_back}" value="/img/back.gif" styleClass="titleImg" />
          </h:commandLink>
           <h:commandLink rendered="#{billBean.puedoImprimir}" action="#" onclick="openPDF('#{billBean.id}','#{billBean.idSelectedOrganization}')" immediate="true">
            <h:graphicImage title="#{msg['bill.print']}" value="/img/page_white_acrobat.png" styleClass="titleImg" />
          </h:commandLink>
        </i:titleBar>
         
        <h:inputHidden id="expiration" value="#{billBean.expiration}" />
        
        <%-- Edition form --%>
        <table class="editTable" cellpadding="0" cellspacing="0">

          <%-- Ignored field: id --%>

           <%-- Field: billType --%>
    	<tr>
            <td class="warning2">${msg['bill.selectType']}</td>

            <td class="editFieldCell">

                <h:panelGroup>
                    <h:message styleClass="error" showSummary="true" showDetail="false" for="billType" />
                    <h:selectOneMenu id="billType" value="#{billBean.billType}" disabled="true">
                        <f:converter converterId="autentia.EnumConverter"/>
                        <f:selectItems value="#{billBean.billTypes}" />
                    </h:selectOneMenu>
                </h:panelGroup>

            </td>
        </tr>

          <%-- Field: sii --%>
          <tr>
              <td class="editLabelRW">${msg['menu.sii']} del Iva</td>

              <td class="editFieldCell">
                  <h:outputText rendered="#{ billBean.bill.submitted == 1 }" value="#{msg['editBill.sii.sended']}"
                                styleClass="requiredFieldClass"/>
                  <h:outputText rendered="#{ billBean.bill.submitted == 0 }" value="#{msg['editBill.sii.notSended']}"
                                styleClass="requiredFieldClass"/>
              </td>
          </tr>
		  
		  <%-- Field: number --%>
          <tr>
            <td class="editLabelRW">*${msg['bill.number']}:</td>
            <td class="editFieldCell">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="number" />
                <h:inputText id="number" readonly="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}" value="#{billBean.number}" required="true" styleClass="requiredFieldClass" maxlength="64"/>
              </h:panelGroup>
            </td>
          </tr>
          
	    <%-- Field: bookNumber --%>
	    <tr>
	      <td class="editLabelRW">${msg['bill.bookNumber']}:</td>      
	      <td class="editFieldCell">
	           <h:panelGroup rendered="#{billBean.receivedBillType}">
	             <h:inputText id="bookNumber" readonly="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}" value="#{billBean.bookNumber}" maxlength="64" />
	           </h:panelGroup>
	      </td>
	    </tr>
         
         <%-- Field: provider --%>
		 <tr>
		    <td class="editLabelRW">${msg['bill.provider']}:</td> 
		    <td class="editFieldCell">
	           <h:panelGroup rendered="#{billBean.puedoPintarProvider}">
	            <h:message styleClass="error" showSummary="true" showDetail="false" for="provider" />
	            <h:selectOneMenu id="provider" disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}" value="#{billBean.provider}" required="true" styleClass="requiredFieldClass">
	              <f:selectItems value="#{billBean.providers}" />
	              <f:converter converterId="autentia.EntityConverter"/>
	            </h:selectOneMenu>
	          </h:panelGroup>          
			</td>
		 </tr>

          <%-- Field: organization --%>
          <tr>
            <td class="editLabelRW">${msg['bill.organization']}:</td>
            <td class="editFieldCell">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="organization" />
                <h:selectOneMenu id="organization" value="#{billBean.selectedOrganization}" immediate="true" onchange="submit()"
                     valueChangeListener="#{billBean.onSelectedOrganizationChanged}" disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}">
                  <f:selectItems value="#{billBean.organizations}" />
                  <f:converter converterId="autentia.EntityConverter"/>
                </h:selectOneMenu>
              </h:panelGroup>
            </td>
          </tr>
          
          <%-- Field: project --%>
          <tr>
            <td class="editLabelRW">*${msg['bill.project']}:</td>
            <td class="editFieldCell">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="project" />
                <h:selectOneMenu id="project" value="#{billBean.project}" required="true" styleClass="requiredFieldClass"
                                 disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}">
                  <f:selectItems value="#{billBean.projectsOpenBySelectedOrganization}" />
                  <f:converter converterId="autentia.EntityConverter"/>
                </h:selectOneMenu>
              </h:panelGroup>
            </td>
          </tr>

              <%-- Field: regimen --%>
          <tr>
              <td class="editLabelRW">*${msg['bill.regime']}:</td>
              <td class="editFieldCell">
                  <h:panelGroup>
                      <h:message styleClass="error" showSummary="true" showDetail="false" for="regimen" />
                      <h:selectOneMenu id="regimen" value="#{billBean.billRegime}" immediate="true"
                                       disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}">
                          <f:selectItems value="#{billBean.billRegimes}" />
                          <f:converter converterId="autentia.EntityConverter"/>
                      </h:selectOneMenu>
                  </h:panelGroup>
              </td>
          </tr>
          
          <%-- Field: name --%>
          <tr>
            <td class="editLabelRW">*${msg['bill.name']}:</td>
            <td class="editFieldCell">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="name" />
                <h:inputTextarea id="name" value="#{billBean.name}" rows="7" cols="68" required="true" styleClass="requiredFieldClass"
                                 readonly="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}"/>
              </h:panelGroup>
            </td>
          </tr>	
          
          <%-- Field: orderNumber --%>
    <tr>
    	    		<td class="editLabelRW">${msg['bill.orderNumber']}:</td>
    	      
      <td class="editFieldCell">

                  <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="orderNumber" />
            <h:inputText id="orderNumber" value="#{billBean.orderNumber}"  maxlength="64" styleClass="requiredFieldClass"
                         readonly="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}"/>
          </h:panelGroup>

              </td>
    </tr>
    
    <%-- Field: contact --%>
    <tr>
    	    		<td class="editLabelRW">${msg['bill.contact']}:</td>
    	      
      <td class="editFieldCell">

                  <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="contact" />
            <h:selectOneMenu id="contact" value="#{billBean.contact}" disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}">
              <f:selectItems value="#{billBean.contactsBySelectedOrganization}" />
              <f:converter converterId="autentia.EntityConverter"/>
            </h:selectOneMenu>
          </h:panelGroup>

              </td>
    </tr>
    
    <tr>
            <td class="editLabelRW">${msg['bill.account']}:</td>
            <td class="editFieldCell">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="account" />
                <h:selectOneMenu id="account" value="#{billBean.selectedAccount}" required="true" styleClass="requiredFieldClass"
                                 disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}">
                  <f:selectItems value="#{billBean.accounts}" />
                  <f:converter converterId="autentia.EntityConverter"/>
                </h:selectOneMenu>
              </h:panelGroup>
            </td>
          </tr>

              <%-- Field: category --%>
              <tr>
                  <td class="editLabelRW">*${msg['bill.type']}:</td>
                  <td class="editFieldCell">
                      <h:panelGroup>
                          <h:message styleClass="error" showSummary="true" showDetail="false" for="billCategory" />
                          <h:selectOneMenu id="billCategory" value="#{billBean.bill.billCategory}" required="true"
                                           styleClass="requiredFieldClass"
                                           onchange="submit();"
                                           readonly="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}"
                                           style="width: 17%; ">
                              <f:selectItems value="#{billBean.billCategories}"/>
                              <f:converter converterId="autentia.EntityConverter"/>
                          </h:selectOneMenu>

                          <h:selectOneMenu id="rectifiedBillCategory" value="#{billBean.bill.rectifiedBillCategory}" required="true"
                                           styleClass="requiredFieldClass"
                                           rendered="#{billBean.bill.billCategory.rectify}"
                                           readonly="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}"
                                           style="width: 17%;">
                              <f:selectItems value="#{billBean.rectifiedBillCategory}"/>
                              <f:converter converterId="autentia.EntityConverter"/>
                          </h:selectOneMenu>
                      </h:panelGroup>
                  </td>
              </tr>

              <%-- Field: provideService --%>
              <tr>
                  <td class="editLabelRW">*${msg['bill.provideService']}:</td>
                  <td class="editFieldCell">
                      <h:panelGroup>
                          <h:message styleClass="error" showSummary="true" showDetail="false" for="provideService" />
                          <h:selectOneRadio id="provideService" value = "#{billBean.provideService}" required="true"
                                            styleClass="requiredFieldClass">
                              <f:selectItem itemValue = "TRUE" itemLabel = "#{msg['msg.yes']}" />
                              <f:selectItem itemValue = "FALSE" itemLabel = "#{msg['msg.no']}" />
                          </h:selectOneRadio>
                      </h:panelGroup>
                  </td>
              </tr>

              <%-- Field: deductibleIVAPercentage --%>
              <tr>
                  <td class="editLabelRW">*${msg['bill.deductibleIVAPercentage']}:</td>
                  <td class="editFieldCell">
                      <h:panelGroup>
                          <h:message styleClass="error" showSummary="true" showDetail="false" for="deductibleIVA" />
                          <h:selectOneRadio id="deductibleIVA" value = "#{billBean.deductibleIVAPercentage}" required="true"
                                            styleClass="requiredFieldClass">
                              <f:selectItem itemValue = "100" itemLabel = "100 %" />
                              <f:selectItem itemValue = "50" itemLabel = "50 %" />
                          </h:selectOneRadio>
                      </h:panelGroup>
                  </td>
              </tr>

           <%-- Field: breakDown --%>
    <tr>
    	    		<td class="editLabelRW">${msg['bill.breakDown']}:</td>
    	      
     				 <td class="editFieldCell">
                            <%@include file="inlineEditBillBreakDown.jsp"%>
          
              </td>
    </tr>
          
          
          <tr>
            <td class="editLabelRW">${msg['bill.totalNoTax']}:</td>
            <td class="editFieldCell" align="right">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="totalNoTaxes" />
                <h:outputText id="totalNoTaxes" value="#{billBean.totalNoTaxes}  " styleClass="requiredFieldClass"/>
                <h:commandLink disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}" action="#{billBean.reloadTotal}">
            		<h:graphicImage title="#{msg['bill.action.reload']}" value="/img/refresh.png" />
          		</h:commandLink>
              </h:panelGroup>
            </td>
          </tr>


          <tr>
            <td class="editLabelRW">${msg['bill.total']}:</td>
            <td class="editFieldCell" align="right">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="total" />
                <h:outputText id="total" value="#{billBean.total}  " styleClass="requiredFieldClass"/>
              </h:panelGroup>
            </td>
          </tr>
		  
		 
          <tr>
            <td class="editLabelRW">${msg['bill.unpaidTotal']}:</td>
            <td class="editFieldCell" align="right">
	             <h:outputText id="unpaid" value="#{billBean.unpaid}"/>
            </td>
          </tr>
		    
		  
		  <%-- Field: creationDate --%>
          <tr>
            <td class="editLabelRW">*${msg['bill.creationDate']}:</td>
            <td class="editFieldCell">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="creationDate" />
                <t:inputCalendar id="creationDate" value="#{billBean.creationDate}"
                                 required="true" styleClass="requiredFieldClass"
                                 renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true"
                                 popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                                 readonly="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}" disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}">
				  <f:validator validatorId="autentia.dateValidator"/>
			    </t:inputCalendar>
              </h:panelGroup>
            </td>
          </tr>
		  
		    <%-- Field: startBillDate --%>
    <tr>
    	    		<td class="editLabelRW">*${msg['bill.startBillDate']}:</td>
    	      
      <td class="editFieldCell">

                  <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="startBillDate" />
            <t:inputCalendar id="startBillDate" value="#{billBean.startBillDate}" required="true" styleClass="requiredFieldClass"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true"
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             readonly="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}" disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}">
				<f:validator validatorId="autentia.dateValidator"/>
			</t:inputCalendar>
          </h:panelGroup>

              </td>
    </tr>
                              
    
    
      <%-- Field: endBillDate --%>
    <tr>
    	    		<td class="editLabelRW">*${msg['bill.endBillDate']}:</td>
    	      
      <td class="editFieldCell">

                  <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="endBillDate" />
            <t:inputCalendar id="endBillDate" value="#{billBean.endBillDate}" required="true" styleClass="requiredFieldClass"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true"
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             readonly="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}" disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}">
				<f:validator validatorId="autentia.dateValidator"/>
			</t:inputCalendar>
          </h:panelGroup>

              </td>
    </tr>

           <%-- Field: payments --%>
    <tr>
    	    		<td class="editLabelRW">${msg['bill.expirationDates']}:</td>
    	      
     				 <td class="editFieldCell">
                            <%@include file="inlineEditBillPayment.jsp"%>
          
              </td>
    </tr>

          <tr>
            <td class="editLabelRW">${msg['bill.billPaymentTotal']}:</td>
            <td class="editFieldCell" align="right">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="billPaymentTotal" />
                <h:outputText id="billPaymentTotal" value="#{billBean.billPaymentTotal}" styleClass="requiredFieldClass"/>
                <h:commandLink disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}" action="#{billBean.reloadTotal}">
            		<h:graphicImage title="#{msg['bill.action.reload']}" value="/img/refresh.png" />
          		</h:commandLink>
          		
          		<h:panelGroup rendered="#{billBean.billPaymentTotal != billBean.total}">
          			<br/>
          			<h:graphicImage value="/img/updated.gif" styleClass="titleImg" />
          			${msg['bill.totalsDontMatchWarning']}
          		</h:panelGroup>
              </h:panelGroup>
            </td>
          </tr>

			
          <%-- Field: paymentMode --%>
          <tr>
            <td class="editLabelRW">*${msg['bill.paymentMode']}:</td>
            <td class="editFieldCell">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="paymentMode" />
                <h:selectOneMenu id="paymentMode" value="#{billBean.paymentMode}" required="true" styleClass="requiredFieldClass"
                                 disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}">
                  <f:converter converterId="autentia.EnumConverter"/>
                  <f:selectItems value="#{billBean.paymentModes}" />
                </h:selectOneMenu>
              </h:panelGroup>
            </td>
          </tr>

          <%-- Field: state --%>
          <tr>
            <td class="editLabelRW">*${msg['bill.state']}:</td>
            <td class="editFieldCell">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="state" />
                <h:selectOneMenu id="state" value="#{billBean.state}" required="true" styleClass="requiredFieldClass"
                                 disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}">
                  <f:converter converterId="autentia.EnumConverter"/>
                  <f:selectItems value="#{billBean.states}" />
                </h:selectOneMenu>
              </h:panelGroup>
            </td>
          </tr>
			
		   

          

          

          <%-- Field: file --%>
          <tr>
            <td class="editLabelRW">${msg['bill.file']}:</td>
            <td class="editFieldCell">
              <i:fileLink type="bill" objectId="${billBean.id}" file="${billBean.file}" mime="${billBean.fileMime}" /> 
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="file" />
                <t:inputFileUpload id="file" size="58" value="#{billBean.uploadFile}" storage="file"
                                   disabled="#{billBean.id != null && billBean.readOnlyBill && billBean.bill.submitted == 1}"/>
              </h:panelGroup>
            </td>
          </tr>

          <%-- Ignored field: fileMime --%>
		
          <%-- Field: observations --%>
          <tr>
            <td class="editLabelRW">${msg['bill.observations']}:</td>
            <td class="editFieldCell">
              <h:panelGroup>
                <h:message styleClass="error" showSummary="true" showDetail="false" for="observations" />
                 <h:inputTextarea id="observations" value="#{billBean.observations}" rows="7" cols="68"/>
              </h:panelGroup>
            </td>
          </tr>
         
          </table>
          <%-- Field: versiones --%>
		  <h:panelGrid rendered="#{billBean.id!=null}" columnClasses="editLabelRW">
		  <h:panelGroup styleClass="editLabelRW">	  
		  <h:outputText  value="#{msg['bill.entries']}" />
            <h:commandLink action="#{billBean.searchEntries}" immediate="true">                      
            	<h:graphicImage title="#{msg['bill.searchEntries']}" value="/img/search.gif" styleClass="titleImg" />
            </h:commandLink> 
           </h:panelGroup>                 
          <h:panelGroup>
                 
                  <%@include file="inlineShowEntries.jsp"%>
          </h:panelGroup>
		 </h:panelGrid>  
        
        
      </h:form>
    </f:view>
    
  </body>
</html>  		

