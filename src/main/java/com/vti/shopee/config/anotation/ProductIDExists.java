package com.vti.shopee.config.anotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER}) // Khai báo vị trí sử dụng
@Retention(RetentionPolicy.RUNTIME) // Khai báo thời điểm sử dụng
@Documented

public @interface ProductIDExists {
    // trường message là bắt buộc, khai báo nội dung sẽ trả về khi field k hợp lệ
    String message() default "Sản phẩm không tồn tại";


    // 2 Cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

