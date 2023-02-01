package com.hengtaierp.utils;

import com.hengtaierp.entity.SystemMenu;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

    public static List<SystemMenu> toTree(List<SystemMenu> treeList, Long pid) {
        List<SystemMenu> retList = new ArrayList<SystemMenu>();
        for (SystemMenu parent : treeList) {
            if (pid.equals(parent.getPid())) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }
    private static SystemMenu findChildren(SystemMenu parent, List<SystemMenu> treeList) {
        for (SystemMenu child : treeList) {
            if (parent.getId().equals(child.getPid())) {
                if (parent.getChild() == null) {
                    parent.setChild(new ArrayList<>());
                }
                parent.getChild().add(findChildren(child, treeList));
            }
        }
        return parent;
    }
}