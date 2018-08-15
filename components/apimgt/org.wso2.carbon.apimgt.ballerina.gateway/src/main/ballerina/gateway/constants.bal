

@Description {value:"Authn scheme basic"}
@final public string AUTHN_SCHEME_BASIC = "basic";
@Description {value:"Authn scheme JWT"}
@final public string AUTH_SCHEME_JWT = "jwt";
@Description {value:"Authn scheme OAuth2"}
@final public string AUTH_SCHEME_OAUTH2 = "oauth2";
@Description {value:"Auth provider config name"}
@final public string AUTH_PROVIDER_CONFIG = "config";
@Description {value:"Authentication header name"}
@final public string AUTH_HEADER = "Authorization";
@Description {value:"Basic authentication scheme"}
@final public string AUTH_SCHEME_BASIC = "Basic";
@Description {value:"Bearer authentication scheme"}
@final public string AUTH_SCHEME_BEARER = "Bearer";
@Description {value:"Auth annotation package"}
@final public string ANN_PACKAGE = "ballerina.http";
@Description {value:"Resource level annotation name"}
@final public string RESOURCE_ANN_NAME = "ResourceConfig";
@Description {value:"Service level annotation name"}
@final public string SERVICE_ANN_NAME = "ServiceConfig";
@Description {value:"Version annotation name in service level"}
@final public string VERSION_ANN_NAME = "Version";
@Description {value:"gateway annotation package"}
@final public string GATEWAY_ANN_PACKAGE = "wso2.gateway";

@Description {value:"Basic prefix for authorization header with ending spce"}
@final public string BASIC_PREFIX_WITH_SPACE = "Basic ";
@Description {value:"authorization header "}
@final public string AUTHORIZATION_HEADER = "Authorization";
@Description {value:"Content type header "}
@final public string CONTENT_TYPE_HEADER = "Content-Type";
@Description {value:"Form url encoded"}
@final public string X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
@final public string API_AUTH_INVALID_CREDENTIALS = "900901";
@Description {value:"X-Forward-For Header "}
@final public string X_FORWARD_FOR_HEADER = "X-FORWARDED-FOR";
@Description {value:"KeyValidation Response"}
@final public string KEY_VALIDATION_RESPONSE = "KEY_VALIDATION_RESPONSE";
@Description {value:"Authentication context attribute"}
@final public string AUTHENTICATION_CONTEXT = "AUTHENTICATION_CONTEXT";
@Description {value:"carbon.super Tenant Domain"}
@final public string SUPER_TENANT_DOMAIN_NAME = "carbon.super";
@Description {value:"Super Tenant Domain Tenant Id"}
@final public int SUPER_TENANT_ID = -1234;
@Description {value:"throttleKey"}
@final public string THROTTLE_KEY = "throttleKey";
@Description { value: "Resource Tier annotation package" }
@final public string RESOURCE_TIER_ANN_PACKAGE = "ballerina.gateway";
@Description { value: "Resource level annotation name" }
@final public string RESOURCE_TIER_ANN_NAME = "ResourceTier";
@Description { value: "Unlimited Tier" }
@final public string UNLIMITED_TIER = "Unlimited";
@Description { value: "Un authenticated tier level" }
@final public string UNAUTHENTICATED_TIER = "Unauthenticated";
@Description { value: "Anonymous user name" }
@final public string END_USER_ANONYMOUS = "anonymous";

// config constants
@Description { value: "Key manager related configs"}
@final public string KM_CONF_INSTANCE_ID = "keyManager";
@Description { value: "Throttling related configs"}
@final public string THROTTLE_CONF_INSTANCE_ID = "Throttling";
@Description { value: "Key manager server URL parameter"}
@final public string KM_SERVER_URL = "serverUrl";
@Description { value: "Block condition state"}
@final public string BLOCKING_CONDITION_STATE = "state";
@Description { value: "Block condition key"}
@final public string BLOCKING_CONDITION_KEY = "blockingCondition";
@Description { value: "Block Condition Value"}
@final public string BLOCKING_CONDITION_VALUE = "conditionValue";

@Description { value: "Listener endpoint related configs"}
@final public string LISTENER_CONF_INSTANCE_ID = "listenerConfig";
@Description { value: "Listener endpoint host"}
@final public string LISTENER_CONF_HOST = "host";
@Description { value: "Listener endpoint http port"}
@final public string LISTENER_CONF_HTTP_PORT = "httpPort";
@Description { value: "Listener endpoint https port"}
@final public string LISTENER_CONF_HTTPS_PORT = "httpsPort";
@Description { value: "Listener endpoint key store path"}
@final public string LISTENER_CONF_KEY_STORE_PATH = "keyStore.path";
@Description { value: "Listener endpoint key store password"}
@final public string LISTENER_CONF_KEY_STORE_PASSWORD = "keyStore.password";

@Description { value: "JWT related configs"}
@final public string JWT_INSTANCE_ID = "jwtConfig";
@Description { value: "JWT issuer"}
@final public string ISSUER = "issuer";
@Description { value: "JWT audience"}
@final public string AUDIENCE = "audience";
@Description { value: "jwt signed cert alias"}
@final public string CERTIFICATE_ALIAS = "certificateAlias";
@Description { value: "trust store  path"}
@final public string TRUST_STORE_PATH = "trustStore.path";
@Description { value: "Trust store password"}
@final public string TRSUT_STORE_PASSWORD = "trustStore.password";

// end of config constants

@Description { value: "Is Throttled"}
@final public string IS_THROTTLED = "isThrottled";
@Description { value: "Expiry TimeStamp"}
@final public string EXPIRY_TIMESTAMP = "expiryTimeStamp";
@final string TRUE = "true";