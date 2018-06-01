package com.moris.material.entity;

/**
 * 素材和表情类型之间的关系表
 */
public class MaterialExpress {

    private int    id;
    private String msg;
    // 父级标签类型 0：乐观 1： 悲观 2：中性
    private int    parentType;
}
