<%--
 Copyright 2016 Karl Dahlgren

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
--%>

<%@ include file="../../../../includes.jspf"%>
<c:url var="operation_update_url"  value="/web/soap/project/${soapProjectId}/port/${soapPort.id}" />
<div class="navigation">
    <ol class="breadcrumb">
        <li><a href="${context}/web"><spring:message code="general.breadcrumb.home"/></a></li>
        <li><a href="${context}/web/soap/project/${soapProjectId}"><spring:message code="soap.breadcrumb.project"/></a></li>
        <li class="active"><spring:message code="soap.soapport.header.port" arguments="${soapPort.name}"/></li>
    </ol>
</div>
<div class="container">
    <section>
        <div class="content-top">
            <div class="title">
                <h1><spring:message code="soap.soapport.header.port" arguments="${soapPort.name}"/></h1>
            </div>
            <div class="menu" align="right">
                <sec:authorize access="hasAuthority('ADMIN') or hasAuthority('MODIFIER')">
                    <a class="btn btn-success demo-button-disabled" href="<c:url value="/web/soap/project/${soapProjectId}/port/${soapPortId}/update"/>"><i class="fa fa-file"></i> <span><spring:message code="soap.soapport.button.updateport"/></span></a>
                    <a class="btn btn-danger demo-button-disabled" href="<c:url value="/web/soap/project/${soapProjectId}/port/${soapPort.id}/delete"/>"><i class="fa fa-trash"></i> <span><spring:message code="soap.soapport.button.deleteport"/></span></a>
                </sec:authorize>
            </div>
        </div>
        <div class="content-summary">
            <table class="formTable">
                <tr>
                    <td class="column1"><label path="name"><spring:message code="soap.soapport.label.name"/></label></td>
                    <td class="column2"><label path="name">${soapPort.name}</label></td>
                </tr>
                <tr>
                    <td class="column1"><label path="name"><spring:message code="soap.soapport.label.uri"/></label></td>
                    <td class="column2"><label path="name">${soapPort.uri}</label></td>
                </tr>
                <tr>
                    <td class="column1"><label path="invokeAddress"><spring:message code="soap.soapport.label.address"/></label></td>
                    <td class="column2"><label path="invokeAddress">${soapPort.invokeAddress}</label></td>
                </tr>
                <tr>
                    <td class="column1"><label path="invokeAddress"><spring:message code="soap.soapport.label.wsdl"/></label></td>
                    <td class="column2"><label path="invokeAddress">${soapPort.invokeAddress}?wsdl</label></td>
                </tr>
            </table>
        </div>

        <h2 class="decorated"><span><spring:message code="soap.soapport.header.operations"/></span></h2>
        <c:choose>
            <c:when test="${soapPort.operations.size() > 0}">
                <form:form action="${operation_update_url}" method="POST"  commandName="soapOperationModifierCommand">
                    <div class="table-responsive">
                        <table class="table table-striped table-hover sortable">
                            <col width="10%">
                            <col width="40%">
                            <col width="15%">
                            <col width="20%">
                            <col width="15%">
                            <tr>
                                <th><spring:message code="soap.soapport.column.selected"/></th>
                                <th><spring:message code="soap.soapport.column.name"/></th>
                                <th><spring:message code="soap.soapport.column.method"/></th>
                                <th><spring:message code="soap.soapport.column.responsestrategy"/></th>
                                <th><spring:message code="soap.soapport.column.soapMockResponseStatus"/></th>
                            </tr>
                            <c:forEach items="${soapPort.operations}" var="soapOperation" varStatus="loopStatus">
                                <tr>
                                    <td><form:checkbox path="soapOperationIds" name="${soapOperation.id}" value="${soapOperation.id}"/></td>
                                    <td><a href="<c:url value="/web/soap/project/${soapProjectId}/port/${soapPort.id}/operation/${soapOperation.id}"/>">${soapOperation.name}</a></td>
                                    <td>${soapOperation.httpMethod}</td>
                                    <td><spring:message code="soap.type.responsestrategy.${soapOperation.responseStrategy}"/></td>
                                    <td><spring:message code="soap.type.soapoperationstatus.${soapOperation.status}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <sec:authorize access="hasAuthority('ADMIN') or hasAuthority('MODIFIER')">
                        <form:select path="soapOperationStatus">
                            <c:forEach items="${soapOperationStatuses}" var="operationStatus">
                                <form:option value="${operationStatus}"><spring:message code="soap.type.soapoperationstatus.${operationStatus}"/></form:option>
                            </c:forEach>
                        </form:select>
                        <button class="btn btn-success demo-button-disabled" type="submit" name="action" value="update"><i class="fa fa-check-circle"></i> <span><spring:message code="soap.soapport.button.updatestatus"/></span></button>
                        <button class="btn btn-primary demo-button-disabled" type="submit" name="action" value="update-endpoint"><i class="fa fa-code-fork"></i> <span><spring:message code="soap.soapport.button.updateendpoint"/></span></button>
                    </sec:authorize>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                </form:form>
            </c:when>
            <c:otherwise>
                <spring:message code="soap.soapport.label.nooperation"/>
            </c:otherwise>
        </c:choose>
    </section>
</div>