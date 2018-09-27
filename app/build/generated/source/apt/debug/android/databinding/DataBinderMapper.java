
package android.databinding;
import com.example.mac.yuejian14.BR;
@javax.annotation.Generated("Android Data Binding")
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 15;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.example.mac.yuejian14.R.layout.activity_register:
                    return com.example.mac.yuejian14.databinding.ActivityRegisterBinding.bind(view, bindingComponent);
                case com.example.mac.yuejian14.R.layout.login:
                    return com.example.mac.yuejian14.databinding.LoginBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 2013163103: {
                if(tag.equals("layout/activity_register_0")) {
                    return com.example.mac.yuejian14.R.layout.activity_register;
                }
                break;
            }
            case -693554443: {
                if(tag.equals("layout/login_0")) {
                    return com.example.mac.yuejian14.R.layout.login;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"};
    }
}