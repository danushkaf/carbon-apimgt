package org.wso2.carbon.apimgt.rest.api.publisher.v1;

import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.*;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.ApisApiService;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.factories.ApisApiServiceFactory;

import io.swagger.annotations.ApiParam;

import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.ErrorDTO;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.DedicatedGatewayDTO;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.DocumentDTO;
import java.io.File;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.DocumentListDTO;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.APIDTO;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.LifecycleStateDTO;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.ScopeListDTO;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.ScopeDTO;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.FileInfoDTO;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.WorkflowResponseDTO;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.APIListDTO;
import org.wso2.carbon.apimgt.rest.api.publisher.v1.dto.APIDefinitionValidationResponseDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/apis")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/apis", description = "the apis API")
public class ApisApi  {

   private final ApisApiService delegate = ApisApiServiceFactory.getApisApi();

    @GET
    @Path("/{apiId}/dedicated-gateway")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get enability of dedicatedGateway", notes = "This operation can be used to retrieve whether the dedicated gateway is enabled in a certain API.\n", response = DedicatedGatewayDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nisEnabled of dedicated Gateway returned\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested Dedicated Gateway does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported.\n") })

    public Response apisApiIdDedicatedGatewayGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdDedicatedGatewayGet(apiId,ifNoneMatch,ifModifiedSince);
    }
    @PUT
    @Path("/{apiId}/dedicated-gateway")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update enabling of dedicated Gateway of API", notes = "This operation can be used to update metadata of an API's dedicatedGateway.\n", response = DedicatedGatewayDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nDedicated Gateway of API updated\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nThe resource to be updated does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdDedicatedGatewayPut(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "dedicated Gateway object that needs to be added\n" ,required=true ) DedicatedGatewayDTO body,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdDedicatedGatewayPut(apiId,body,ifMatch,ifUnmodifiedSince);
    }
    @DELETE
    @Path("/{apiId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete an API", notes = "This operation can be used to delete an existing API proving the Id of the API.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nResource successfully deleted.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden.\nThe request must be conditional but no condition has been specified.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nResource to be deleted does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdDelete(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdDelete(apiId,ifMatch,ifUnmodifiedSince);
    }
    @GET
    @Path("/{apiId}/documents/{documentId}/content")
    @Consumes({ "application/json" })
    @Produces({ "application/octet-stream" })
    @io.swagger.annotations.ApiOperation(value = "Get the content of an API document", notes = "This operation can be used to retrive the content of an API's document.\n\nThe document can be of 3 types. In each cases responses are different.\n\n1. **Inline type**:\n   The content of the document will be retrieved in `text/plain` content type\n2. **FILE type**:\n   The file will be downloaded with the related content type (eg. `application/pdf`)\n3. **URL type**:\n    The client will recieve the URL of the document as the Location header with the response with - `303 See Other`\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nFile or inline content returned.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 303, message = "See Other.\nSource can be retrived from the URL specified at the Location header.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested Document does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisApiIdDocumentsDocumentIdContentGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Document Identifier\n",required=true ) @PathParam("documentId")  String documentId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdDocumentsDocumentIdContentGet(apiId,documentId,ifNoneMatch,ifModifiedSince);
    }
    @POST
    @Path("/{apiId}/documents/{documentId}/content")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Upload the content of an API document", notes = "Thid operation can be used to upload a file or add inline content to an API document.\n\n**IMPORTANT:**\n* Either **file** or **inlineContent** form data parameters should be specified at one time.\n* Document's source type should be **FILE** in order to upload a file to the document using **file** parameter.\n* Document's source type should be **INLINE** in order to add inline content to the document using **inlineContent** parameter.\n", response = DocumentDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nDocument updated\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nThe resource to be updated does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdDocumentsDocumentIdContentPost(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Document Identifier\n",required=true ) @PathParam("documentId")  String documentId,
    @ApiParam(value = "Document to upload") @Multipart(value = "file", required = false) InputStream fileInputStream,
    @ApiParam(value = "Document to upload : details") @Multipart(value = "file" , required = false) Attachment fileDetail,
    @ApiParam(value = "Inline content of the document" )@Multipart(value = "inlineContent", required = false)  String inlineContent,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdDocumentsDocumentIdContentPost(apiId,documentId,fileInputStream,fileDetail,inlineContent,ifMatch,ifUnmodifiedSince);
    }
    @DELETE
    @Path("/{apiId}/documents/{documentId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a document of an API", notes = "This operation can be used to delete a document associated with an API.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nResource successfully deleted.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nResource to be deleted does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdDocumentsDocumentIdDelete(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Document Identifier\n",required=true ) @PathParam("documentId")  String documentId,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdDocumentsDocumentIdDelete(apiId,documentId,ifMatch,ifUnmodifiedSince);
    }
    @GET
    @Path("/{apiId}/documents/{documentId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a document of an API", notes = "This operation can be used to retrieve a particular document's metadata associated with an API.\n", response = DocumentDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nDocument returned.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested Document does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisApiIdDocumentsDocumentIdGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Document Identifier\n",required=true ) @PathParam("documentId")  String documentId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdDocumentsDocumentIdGet(apiId,documentId,ifNoneMatch,ifModifiedSince);
    }
    @PUT
    @Path("/{apiId}/documents/{documentId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a document of an API", notes = "This operation can be used to update metadata of an API's document.\n", response = DocumentDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nDocument updated\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nThe resource to be updated does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdDocumentsDocumentIdPut(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Document Identifier\n",required=true ) @PathParam("documentId")  String documentId,
    @ApiParam(value = "Document object that needs to be added\n" ,required=true ) DocumentDTO body,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdDocumentsDocumentIdPut(apiId,documentId,body,ifMatch,ifUnmodifiedSince);
    }
    @GET
    @Path("/{apiId}/documents")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a list of documents of an API", notes = "This operation can be used to retrieve a list of documents belonging to an API by providing the id of the API.\n", response = DocumentListDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nDocument list is returned.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisApiIdDocumentsGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Maximum size of resource array to return.\n", defaultValue="25") @QueryParam("limit")  Integer limit,
    @ApiParam(value = "Starting point within the complete list of items qualified.\n", defaultValue="0") @QueryParam("offset")  Integer offset,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch)
    {
    return delegate.apisApiIdDocumentsGet(apiId,limit,offset,ifNoneMatch);
    }
    @POST
    @Path("/{apiId}/documents")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a new document to an API", notes = "This operation can be used to add a new documentation to an API. This operation only adds the metadata of a document. To add the actual content we need to use **Upload the content of an API document ** API once we obtain a document Id by this operation.\n", response = DocumentDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created.\nSuccessful response with the newly created Document object as entity in the body.\nLocation header contains URL of newly added document.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error\n"),
        
        @io.swagger.annotations.ApiResponse(code = 415, message = "Unsupported media type.\nThe entity of the request was in a not supported format.\n") })

    public Response apisApiIdDocumentsPost(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Document object that needs to be added\n" ,required=true ) DocumentDTO body,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdDocumentsPost(apiId,body,ifMatch,ifUnmodifiedSince);
    }
    @GET
    @Path("/{apiId}/gateway-config")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get gateway definition", notes = "This operation can be used to retrieve the gateway configuration of an API.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nRequested gateway configuration of the API is returned\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisApiIdGatewayConfigGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdGatewayConfigGet(apiId,ifNoneMatch,ifModifiedSince);
    }
    @PUT
    @Path("/{apiId}/gateway-config")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update gateway configuration", notes = "This operation can be used to update the gateway configuration of an existing API. gateway configuration to be updated is passed as a form data parameter `gatewayConfig`.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nSuccessful response with updated gateway configuration\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error\n"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden.\nThe request must be conditional but no condition has been specified.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nThe resource to be updated does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdGatewayConfigPut(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "gateway configuration of the API", required=true )@Multipart(value = "gatewayConfig")  String gatewayConfig,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdGatewayConfigPut(apiId,gatewayConfig,ifMatch,ifUnmodifiedSince);
    }
    @GET
    @Path("/{apiId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get details of an API", notes = "Using this operation, you can retrieve complete details of a single API. You need to provide the Id of the API to retrive it.\n", response = APIDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nRequested API is returned\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisApiIdGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdGet(apiId,ifNoneMatch,ifModifiedSince);
    }
    @GET
    @Path("/{apiId}/lifecycle")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get Lifecycle state data of the API.", notes = "This operation can be used to retrieve Lifecycle state data of the API.\n", response = LifecycleStateDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nLifecycle state data returned successfully.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdLifecycleGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdLifecycleGet(apiId,ifNoneMatch,ifModifiedSince);
    }
    @GET
    @Path("/{apiId}/lifecycle-history")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get Lifecycle state change history of the API.", notes = "This operation can be used to retrieve Lifecycle state change history of the API.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nLifecycle state change history returned successfully.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdLifecycleHistoryGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdLifecycleHistoryGet(apiId,ifNoneMatch,ifModifiedSince);
    }
    @DELETE
    @Path("/{apiId}/lifecycle/lifecycle-pending-task")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete pending lifecycle state change tasks.", notes = "This operation can be used to remove pending lifecycle state change requests that are in pending state\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nLifecycle state change pending task removed successfully.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdLifecycleLifecyclePendingTaskDelete(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId)
    {
    return delegate.apisApiIdLifecycleLifecyclePendingTaskDelete(apiId);
    }
    @PUT
    @Path("/{apiId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update an API", notes = "This operation can be used to update an existing API.\nBut the properties `name`, `version`, `context`, `provider`, `state` will not be changed by this operation.\n", response = APIDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nSuccessful response with updated API object\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error\n"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden.\nThe request must be conditional but no condition has been specified.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nThe resource to be updated does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdPut(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "API object that needs to be added\n" ,required=true ) APIDTO body,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdPut(apiId,body,ifMatch,ifUnmodifiedSince);
    }
    @GET
    @Path("/{apiId}/scopes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a list of scopes of an API", notes = "This operation can be used to retrieve a list of scopes belonging to an API by providing the id of the API.\n", response = ScopeListDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nScope list is returned.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisApiIdScopesGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch)
    {
    return delegate.apisApiIdScopesGet(apiId,ifNoneMatch);
    }
    @DELETE
    @Path("/{apiId}/scopes/{name}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a scope of an API", notes = "This operation can be used to delete a scope associated with an API.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nResource successfully deleted.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nResource to be deleted does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdScopesNameDelete(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Scope name\n",required=true ) @PathParam("name")  String name,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdScopesNameDelete(apiId,name,ifMatch,ifUnmodifiedSince);
    }
    @GET
    @Path("/{apiId}/scopes/{name}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a scope of an API", notes = "This operation can be used to retrieve a particular scope's metadata associated with an API.\n", response = ScopeDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nScope returned.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested Scope does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisApiIdScopesNameGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Scope name\n",required=true ) @PathParam("name")  String name,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdScopesNameGet(apiId,name,ifNoneMatch,ifModifiedSince);
    }
    @PUT
    @Path("/{apiId}/scopes/{name}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a Scope of an API", notes = "This operation can be used to update scope of an API\n", response = ScopeDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nScope updated\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nThe resource to be updated does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdScopesNamePut(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Scope name\n",required=true ) @PathParam("name")  String name,
    @ApiParam(value = "Scope object that needs to be added\n" ,required=true ) ScopeDTO body,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdScopesNamePut(apiId,name,body,ifMatch,ifUnmodifiedSince);
    }
    @POST
    @Path("/{apiId}/scopes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a new scope to an API", notes = "This operation can be used to add a new scope to an API.\n", response = ScopeDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created.\nSuccessful response with the newly created Scope object as entity in the body.\nLocation header contains URL of newly added scope.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error\n"),
        
        @io.swagger.annotations.ApiResponse(code = 415, message = "Unsupported media type.\nThe entity of the request was in a not supported format.\n") })

    public Response apisApiIdScopesPost(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Scope object that needs to be added\n" ,required=true ) ScopeDTO body,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdScopesPost(apiId,body,ifMatch,ifUnmodifiedSince);
    }
    @GET
    @Path("/{apiId}/swagger")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get swagger definition", notes = "This operation can be used to retrieve the swagger definition of an API.\n", response = String.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nRequested swagger document of the API is returned\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisApiIdSwaggerGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdSwaggerGet(apiId,ifNoneMatch,ifModifiedSince);
    }
    @PUT
    @Path("/{apiId}/swagger")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update swagger definition", notes = "This operation can be used to update the swagger definition of an existing API. Swagger definition to be updated is passed as a form data parameter `apiDefinition`.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nSuccessful response with updated Swagger definition\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error\n"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden.\nThe request must be conditional but no condition has been specified.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nThe resource to be updated does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdSwaggerPut(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Swagger definition of the API", required=true )@Multipart(value = "endpointId")  String endpointId,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdSwaggerPut(apiId,endpointId,ifMatch,ifUnmodifiedSince);
    }
    @DELETE
    @Path("/{apiId}/threat-protection-policies")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a threat protection policy from an API", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Ok. Policy deleted successfully."),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Specified API or Policy not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Error while deleting the policy") })

    public Response apisApiIdThreatProtectionPoliciesDelete(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Threat protection policy id",required=true) @QueryParam("policyId")  String policyId)
    {
    return delegate.apisApiIdThreatProtectionPoliciesDelete(apiId,policyId);
    }
    @GET
    @Path("/{apiId}/threat-protection-policies")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all threat protection policies associated with an API", notes = "", response = String.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Ok. List of policy ids is returned"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Specified API was not found."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Error retrieving threat protection policies") })

    public Response apisApiIdThreatProtectionPoliciesGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId)
    {
    return delegate.apisApiIdThreatProtectionPoliciesGet(apiId);
    }
    @POST
    @Path("/{apiId}/threat-protection-policies")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a threat protection policy to an API", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Ok. Policy added succesfuly."),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Specified API or Policy not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal server error while adding policy") })

    public Response apisApiIdThreatProtectionPoliciesPost(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Threat protection policy id",required=true) @QueryParam("policyId")  String policyId)
    {
    return delegate.apisApiIdThreatProtectionPoliciesPost(apiId,policyId);
    }
    @GET
    @Path("/{apiId}/thumbnail")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get thumbnail image", notes = "This operation can be used to download a thumbnail image of an API.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nThumbnail image returned\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested Document does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisApiIdThumbnailGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdThumbnailGet(apiId,ifNoneMatch,ifModifiedSince);
    }
    @POST
    @Path("/{apiId}/thumbnail")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Upload a thumbnail image", notes = "This operation can be used to upload a thumbnail image of an API. The thumbnail to be uploaded should be given as a form data parameter `file`.\n", response = FileInfoDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nImage updated\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nThe resource to be updated does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdThumbnailPost(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Image to upload") @Multipart(value = "file") InputStream fileInputStream,
    @ApiParam(value = "Image to upload : details") @Multipart(value = "file" ) Attachment fileDetail,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdThumbnailPost(apiId,fileInputStream,fileDetail,ifMatch,ifUnmodifiedSince);
    }
    @GET
    @Path("/{apiId}/wsdl")
    @Consumes({ "application/json" })
    @Produces({ "application/octet-stream" })
    @io.swagger.annotations.ApiOperation(value = "Get swagger definition", notes = "This operation can be used to retrieve the swagger definition of an API.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nRequested WSDL document of the API is returned\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisApiIdWsdlGet(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header of the\nformerly retrieved variant of the resource.\n"  )@HeaderParam("If-Modified-Since") String ifModifiedSince)
    {
    return delegate.apisApiIdWsdlGet(apiId,ifNoneMatch,ifModifiedSince);
    }
    @PUT
    @Path("/{apiId}/wsdl")
    @Consumes({ "multipart/form-ldata" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update WSDL definition", notes = "This operation can be used to update the WSDL definition of an existing API. WSDL to be updated is passed as a form data parameter `inlineContent`.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nSuccessful response with updated WSDL definition\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error\n"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden.\nThe request must be conditional but no condition has been specified.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nThe resource to be updated does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisApiIdWsdlPut(@ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API ID.\nShould be formatted as **provider-name-version**.\n",required=true ) @PathParam("apiId")  String apiId,
    @ApiParam(value = "WSDL file or archive to upload") @Multipart(value = "file") InputStream fileInputStream,
    @ApiParam(value = "WSDL file or archive to upload : details") @Multipart(value = "file" ) Attachment fileDetail,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisApiIdWsdlPut(apiId,fileInputStream,fileDetail,ifMatch,ifUnmodifiedSince);
    }
    @POST
    @Path("/change-lifecycle")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Change API Status", notes = "This operation is used to change the lifecycle of an API. Eg: Publish an API which is in `CREATED` state. In order to change the lifecycle, we need to provide the lifecycle `action` as a query parameter.\n\nFor example, to Publish an API, `action` should be `Publish`.\n\nSome actions supports providing additional paramters which should be provided as `lifecycleChecklist` parameter. Please see parameters table for more information.\n", response = WorkflowResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nLifecycle changed successfully.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 202, message = "Accepted.\nThe request has been accepted.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Conflict.\nPending workflow task exists.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "Precondition Failed.\nThe request has not been performed because one of the preconditions is not met.\n") })

    public Response apisChangeLifecyclePost(@ApiParam(value = "The action to demote or promote the state of the API.\n\nSupported actions are [ **Publish, Deploy as a Prototype, Demote to Created, Demote to Prototyped, Move to Maintenance, Deprecate, Re-Publish, Retire **]\n",required=true, allowableValues="{values=[Publish, Deploy as a Prototype, Demote to Created, Demote to Prototyped, Move to Maintenance, Deprecate, Re-Publish, Retire]}") @QueryParam("action")  String action,
    @ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API I.\nShould be formatted as **provider-name-version**.\n",required=true) @QueryParam("apiId")  String apiId,
    @ApiParam(value = "\nYou can specify additional checklist items by using an **\"attribute:\"** modifier.\n\nEg: \"Deprecate Old Versions:true\" will deprecate older versions of a particular API when it is promoted to\nPublished state from Created state. Multiple checklist items can be given in \"attribute1:true, attribute2:false\"\nformat.\n\nSupported checklist items are as follows.\n1. **Deprecate Old Versions**: Setting this to true will deprecate older versions of a particular API when it is promoted to Published state from Created state.\n2. **Require Re-Subscription**: If you set this to true, users need to re subscribe to the API although they may have subscribed to an older version.\n") @QueryParam("lifecycleChecklist")  String lifecycleChecklist,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisChangeLifecyclePost(action,apiId,lifecycleChecklist,ifMatch,ifUnmodifiedSince);
    }
    @POST
    @Path("/copy-api")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a new API version", notes = "This operation can be used to create a new version of an existing API. The new version is specified as `newVersion` query parameter. New API will be in `CREATED` state.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created.\nSuccessful response with the newly created API as entity in the body. Location header contains URL of newly created API.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nAPI to copy does not exist.\n") })

    public Response apisCopyApiPost(@ApiParam(value = "Version of the new API.",required=true) @QueryParam("newVersion")  String newVersion,
    @ApiParam(value = "**API ID** consisting of the **UUID** of the API.\nThe combination of the provider of the API, name of the API and the version is also accepted as a valid API I.\nShould be formatted as **provider-name-version**.\n",required=true) @QueryParam("apiId")  String apiId)
    {
    return delegate.apisCopyApiPost(newVersion,apiId);
    }
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve/Search APIs\n", notes = "This operation provides you a list of available APIs qualifying under a given search condition.\n\nEach retrieved API is represented with a minimal amount of attributes. If you want to get complete details of an API, you need to use **Get details of an API** operation.\n", response = APIListDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nList of qualifying APIs is returned.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 304, message = "Not Modified.\nEmpty body because the client has already the latest version of the requested resource (Will be supported in future).\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisGet(@ApiParam(value = "Maximum size of resource array to return.\n", defaultValue="25") @QueryParam("limit")  Integer limit,
    @ApiParam(value = "Starting point within the complete list of items qualified.\n", defaultValue="0") @QueryParam("offset")  Integer offset,
    @ApiParam(value = "**Search condition**.\n\nYou can search in attributes by using an **\"<attribute>:\"** modifier.\n\nEg.\n\"provider:wso2\" will match an API if the provider of the API is exactly \"wso2\".\n\nAdditionally you can use wildcards.\n\nEg.\n\"provider:wso2*\" will match an API if the provider of the API starts with \"wso2\".\n\nSupported attribute modifiers are [**version, context, lifeCycleStatus,\ndescription, subcontext, doc, provider**]\n\nIf no advanced attribute modifier has been specified, search will match the\ngiven query string against API Name.\n") @QueryParam("query")  String query,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch)
    {
    return delegate.apisGet(limit,offset,query,ifNoneMatch);
    }
    @HEAD
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Check given API attibute name is already exist\n", notes = "Using this operation, you can check a given API context is already used. You need to provide the context name you want to check.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nRequested API attibute status is returned\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nRequested API attribute does not meet requiremnts.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nRequested API attribute does not exist.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 406, message = "Not Acceptable.\nThe requested media type is not supported\n") })

    public Response apisHead(@ApiParam(value = "**Search condition**.\n\nYou can search in attributes by using an **\"<attribute>:\"** modifier.\n\nEg.\n\"provider:wso2\" will match an API if the provider of the API is exactly \"wso2\".\n\nAdditionally you can use wildcards.\n\nEg.\n\"provider:wso2*\" will match an API if the provider of the API starts with \"wso2\".\n\nSupported attribute modifiers are [**version, context, lifeCycleStatus,\ndescription, subcontext, doc, provider**]\n\nIf no advanced attribute modifier has been specified, search will match the\ngiven query string against API Name.\n") @QueryParam("query")  String query,
    @ApiParam(value = "Validator for conditional requests; based on the ETag of the formerly retrieved\nvariant of the resourec.\n"  )@HeaderParam("If-None-Match") String ifNoneMatch)
    {
    return delegate.apisHead(query,ifNoneMatch);
    }
    @POST
    @Path("/import-definition")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Import API Definition", notes = "This operation can be used to create api from api definition.\n\nAPI definition can be either Swagger or a WSDL\n\nWSDL can be speficied as a single file or a ZIP archive with WSDLs and reference XSDs etc.\nWhen the type is WSDL, it is a **must** to specify additionalProperties with API's name, version, context and endpoints. See the example for additionalProperties.\n", response = APIDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created.\nSuccessful response with the newly created object as entity in the body.\nLocation header contains URL of newly created entity.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 415, message = "Unsupported Media Type.\nThe entity of the request was in a not supported format.\n") })

    public Response apisImportDefinitionPost(@ApiParam(value = "Definition type to upload" , allowableValues="{values=[SWAGGER, WSDL]}", defaultValue="SWAGGER")@Multipart(value = "type", required = false)  String type,
    @ApiParam(value = "Definition to uploadas a file") @Multipart(value = "file", required = false) InputStream fileInputStream,
    @ApiParam(value = "Definition to uploadas a file : details") @Multipart(value = "file" , required = false) Attachment fileDetail,
    @ApiParam(value = "Definition url" )@Multipart(value = "url", required = false)  String url,
    @ApiParam(value = "Additional attributes specified as a stringified JSON with API's schema" )@Multipart(value = "additionalProperties", required = false)  String additionalProperties,
    @ApiParam(value = "Currently this is only used when creating an API using a WSDL.\n\nIf 'SOAP' is specified, the API will be created with only one resource 'POST /' which is to be used for SOAP\noperations.\n\nIf 'HTTP_BINDING' is specified, the API will be created with resources using HTTP binding operations\nwhich are extracted from the WSDL.\n" , allowableValues="{values=[soap, httpBinding]}", defaultValue="SOAP")@Multipart(value = "implementationType", required = false)  String implementationType,
    @ApiParam(value = "Validator for conditional requests; based on ETag.\n"  )@HeaderParam("If-Match") String ifMatch,
    @ApiParam(value = "Validator for conditional requests; based on Last Modified header.\n"  )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince)
    {
    return delegate.apisImportDefinitionPost(type,fileInputStream,fileDetail,url,additionalProperties,implementationType,ifMatch,ifUnmodifiedSince);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a new API", notes = "This operation can be used to create a new API specifying the details of the API in the payload. The new API will be in `CREATED` state.\n\nThere is a special capability for a user who has `APIM Admin` permission such that he can create APIs on behalf of other users. For that he can to specify `\"provider\" : \"some_other_user\"` in the payload so that the API's creator will be shown as `some_other_user` in the UI.\n", response = APIDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created.\nSuccessful response with the newly created object as entity in the body.\nLocation header contains URL of newly created entity.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 415, message = "Unsupported Media Type.\nThe entity of the request was in a not supported format.\n") })

    public Response apisPost(@ApiParam(value = "API object that needs to be added\n" ,required=true ) APIDTO body)
    {
    return delegate.apisPost(body);
    }
    @POST
    @Path("/validate-definition")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Validate API definition and retrieve a summary", notes = "This operation can be used to validate a swagger or WSDL definition and retrieve a summary.\n", response = APIDefinitionValidationResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK.\nAPI definition validation information is returned\n"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request.\nInvalid request or validation error.\n"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found.\nWorkflow for the given reference in not found.\n") })

    public Response apisValidateDefinitionPost(@ApiParam(value = "Definition type to upload", required=true , allowableValues="{values=[SWAGGER, WSDL]}", defaultValue="SWAGGER")@Multipart(value = "type")  String type,
    @ApiParam(value = "Definition to upload as a file") @Multipart(value = "file", required = false) InputStream fileInputStream,
    @ApiParam(value = "Definition to upload as a file : details") @Multipart(value = "file" , required = false) Attachment fileDetail,
    @ApiParam(value = "Definition url" )@Multipart(value = "url", required = false)  String url)
    {
    return delegate.apisValidateDefinitionPost(type,fileInputStream,fileDetail,url);
    }
}
