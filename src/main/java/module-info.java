module lan.zold {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens lan.zold to javafx.fxml;
    opens lan.zold.models to javafx.base,javafx.fxml;
    exports lan.zold;
}
