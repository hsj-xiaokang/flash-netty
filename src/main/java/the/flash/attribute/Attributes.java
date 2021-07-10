package the.flash.attribute;

import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    
    AttributeKey<Boolean> LOGIN_SERVE = AttributeKey.newInstance("login_serve");
}
