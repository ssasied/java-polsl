module com.library.ml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.library.ml to javafx.fxml;
    opens model to javafx.base;
    exports com.library.ml;
}
