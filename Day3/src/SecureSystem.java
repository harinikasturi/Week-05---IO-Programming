import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureSystem {
    @RoleAllowed("ADMIN")
    public void accessAdminPanel(String role) throws Exception {
        Method method = this.getClass().getMethod("accessAdminPanel", String.class);
        RoleAllowed ra = method.getAnnotation(RoleAllowed.class);
        if (!ra.value().equals(role)) {
            System.out.println("Access Denied!");
            return;
        }
        System.out.println("Access Granted to Admin Panel");
    }
}

class Main9 {
    public static void main(String[] args) throws Exception {
        SecureSystem ss = new SecureSystem();
        ss.accessAdminPanel("USER");
        ss.accessAdminPanel("ADMIN");
    }
}
