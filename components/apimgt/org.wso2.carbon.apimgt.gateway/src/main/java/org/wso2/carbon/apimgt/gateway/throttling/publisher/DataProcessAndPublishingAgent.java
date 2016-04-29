package org.wso2.carbon.apimgt.gateway.throttling.publisher;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.apache.synapse.rest.RESTConstants;
import org.apache.synapse.rest.RESTUtils;
import org.wso2.carbon.apimgt.gateway.handlers.security.APISecurityUtils;
import org.wso2.carbon.apimgt.gateway.handlers.security.AuthenticationContext;
import org.wso2.carbon.apimgt.impl.utils.APIUtil;
import org.wso2.carbon.databridge.agent.DataPublisher;
import org.wso2.carbon.utils.multitenancy.MultitenantUtils;

/**
 * This class is responsible for executing data publishing logic. This class implements runnable interface and
 * need to execute using thread pool executor. Primary task of this class it is accept message context as parameter
 * and perform time consuming data extraction and publish event to data publisher. Having data extraction and
 * transformation logic in this class will help to reduce overhead added to main message flow.
 */
public class DataProcessAndPublishingAgent implements Runnable{
    private static final Log log = LogFactory.getLog(DataProcessAndPublishingAgent.class);

    private static String streamID = "org.wso2.throttle.request.stream:1.0.0";
    private MessageContext messageContext;
    private DataPublisher dataPublisher = ThrottleDataPublisher.getDataPublisher();
    String applicationLevelThrottleKey;
    String applicationLevelTier;
    String apiLevelThrottleKey;
    String apiLevelTier;
    String subscriptionLevelThrottleKey;
    String subscriptionLevelTier;
    String resourceLevelThrottleKey;
    String authorizedUser;
    String resourceLevelTier;
    String apiContext;
    String apiVersion;
    String appTenant;
    String apiTenant;
    String apiName;
    String appId;


    public DataProcessAndPublishingAgent() {

    }

    /**
     * This method will use to set message context.
     * @param messageContext
     */
    public void setDataReference(String applicationLevelThrottleKey, String applicationLevelTier,
                                 String apiLevelThrottleKey, String apiLevelTier,
                                 String subscriptionLevelThrottleKey, String subscriptionLevelTier,
                                 String resourceLevelThrottleKey, String resourceLevelTier,
                                 String authorizedUser, String apiContext, String apiVersion, String appTenant,
                                 String appId, MessageContext messageContext){
        if(resourceLevelTier==null && apiLevelTier!=null){
            resourceLevelTier = apiLevelTier;
        }
        this.messageContext =messageContext;
        this.applicationLevelThrottleKey =applicationLevelThrottleKey;
        this.applicationLevelTier = applicationLevelTier;
        this.apiLevelThrottleKey = apiLevelThrottleKey;
        this.applicationLevelTier = apiLevelTier;
        this.subscriptionLevelThrottleKey = subscriptionLevelThrottleKey;
        this.subscriptionLevelTier = subscriptionLevelTier;
        this.resourceLevelThrottleKey = resourceLevelThrottleKey;
        this.resourceLevelTier =resourceLevelTier;
        this.authorizedUser = authorizedUser;
        this.apiContext = apiContext;
        this.apiVersion = apiVersion;
        this.appTenant = appTenant;
        this.apiTenant = MultitenantUtils.getTenantDomainFromRequestURL(RESTUtils.getFullRequestPath
                (messageContext)); //TODO this may be efficient hence double check
        this.appId = appId;
        String apiName = (String) messageContext.getProperty(RESTConstants.SYNAPSE_REST_API);
        this.apiName = APIUtil.getAPINamefromRESTAPI(apiName);
    }

    public void run() {
        //TODO implement logic to get message details from message context
        AuthenticationContext authContext = APISecurityUtils.getAuthenticationContext(messageContext);
        String propertiesMap = "{\n" +
                "  \"name\": \"org.wso2.throttle.request.stream\",\n" +
                "  \"version\": \"1.0.0\"}";

        Object[] objects = new Object[]{messageContext.getMessageID(), this.applicationLevelThrottleKey,this.applicationLevelTier,
                this.apiLevelThrottleKey, this.apiLevelTier,
                this.subscriptionLevelThrottleKey, this.subscriptionLevelTier,
                this.resourceLevelThrottleKey, this.resourceLevelTier,
                this.authorizedUser, this.apiContext, this.apiVersion, this.appTenant, this.apiTenant, this.appId ,this.apiName ,propertiesMap};

        org.wso2.carbon.databridge.commons.Event event = new org.wso2.carbon.databridge.commons.Event(streamID,
                System.currentTimeMillis(), null, null, objects);
        dataPublisher.tryPublish(event);
    }

}
