package com.xzsd.pc.upload;

import org.apache.ibatis.annotations.Param;

public interface UploadDao {
    int savePhoto(@Param("photo")String photo);
}
