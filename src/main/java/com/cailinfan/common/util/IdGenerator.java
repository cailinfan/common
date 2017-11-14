package com.cailinfan.common.util;

import java.util.UUID;

/**
 * Created by cailinfan on 2017/6/24.
 */
public abstract class IdGenerator {

    public static String generateUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}
