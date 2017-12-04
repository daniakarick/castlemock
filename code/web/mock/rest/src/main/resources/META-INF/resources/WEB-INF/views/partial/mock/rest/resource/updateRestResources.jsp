<%--
 Copyright 2017 Karl Dahlgren

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
<c:url var="update_resources_endpoint_url"  value="/web/rest/project/${restProjectId}/application/${restApplicationId}/resource/update/confirm" />
<div class="navigation">
    <ol class="breadcrumb">
        <li><a href="${context}/web"><spring:message code="general.breadcrumb.home"/></a></li>
        <li><a href="${context}/web/rest/project/${restProjectId}"><spring:message code="rest.breadcrumb.project"/></a></li>
        <li><a href="${context}/web/rest/project/${restProjectId}/application/${restApplicationId}"><spring:message code="rest.breadcrumb.application"/></a></li>
        <li class="active"><spring:message code="rest.updaterestresources.header.updateresource"/></li>
    </ol>
</div>
<div class="container">
    <section>
        <div class="content-top">
            <h1><spring:message code="rest.updaterestresources.header.updateresource"/></h1>
        </div>
        <c:choose>
            <c:when test="${restResources.size() > 0}">
                <p><spring:message code="rest.updaterestresources.label.confirmation"/></p>
                <form:form action="${update_resources_endpoint_url}" method="POST" commandName="updateRestResourcesCommand">
                    <ul>
                        <c:forEach items="${restResources}" var="restResource" varStatus="loopStatus">
                            <li>${restResource.name}</li>
                            <form:hidden path="restResources[${loopStatus.index}].id" value="${restResource.id}"/>
                        </c:forEach>
                    </ul>
                    <table class="formTable">
                        <tr>
                            <td class="column1"><spring:message code="rest.updaterestresources.label.methodstatus"/></td>
                            <td>
                                <form:select path="status">
                                    <c:forEach items="${restMethodStatuses}" var="restMethodStatus">
                                        <spring:message var="label" code="rest.type.restmethodstatus.${restMethodStatus}"/>
                                        <form:option value="${restMethodStatus}" label="${label}"/>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td class="column1"><spring:message code="rest.updaterestresources.label.responsestrategy"/></td>
                            <td>
                                <form:select path="responseStrategy">
                                    <c:forEach items="${restResponsestrategies}" var="restResponseStrategy">
                                        <spring:message var="label" code="rest.type.responsestrategy.${restResponseStrategy}"/>
                                        <form:option value="${restResponseStrategy}" label="${label}"/>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td class="column1"><label path="forwardedEndpoint"><spring:message code="rest.updaterestresources.label.forwardedendpoint"/></label></td>
                            <td class="column2"><form:input path="forwardedEndpoint" value="${updateRestResourcesCommand.forwardedEndpoint}"/></td>
                        </tr>
                        <tr>
                            <td class="column1"><label path="name"><spring:message code="rest.updaterestresources.label.networkdelay"/> (ms)</label></td>
                            <td class="column2"><form:input path="networkDelay" value="${updateRestResourcesCommand.networkDelay}"/></td>
                        </tr>
                        <tr>
                            <td class="column1"><form:label path="simulateNetworkDelay"><spring:message code="rest.updaterestresources.label.simulatenetworkdelay"/></form:label></td>
                            <td class="column2"><span class="checkbox"><form:checkbox path="simulateNetworkDelay"/></span></td>
                        </tr>
                    </table>
                    <button class="btn btn-success"><i class="fa fa-check-circle"></i> <span><spring:message code="rest.updaterestresources.button.updateresources"/></span></button>
                    <a href="<c:url value="/web/rest/project/${restProjectId}/application/${restApplicationId}"/>" class="btn btn-primary"><i class="fa fa-times"></i> <spring:message code="rest.updaterestresources.button.cancel"/></a>
                </form:form>
            </c:when>
            <c:otherwise>
                <p><spring:message code="rest.updaterestresources.label.noresources"/></p>
                <a href="<c:url value="/web/rest/project/${restProjectId}/application/${restApplicationId}"/>" class="btn btn-primary"><i class="fa fa-times"></i> <spring:message code="rest.updaterestresources.button.cancel"/></a>
            </c:otherwise>
        </c:choose>
    </section>
</div>