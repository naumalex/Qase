package utils;

import models.defect.Defect;
import models.defect.Tag;

import java.util.ArrayList;
import java.util.List;

public class DefectFactory {
        public static Defect getFirstDefectInfo() {
            return Defect.builder()
                .id(Integer.parseInt(PropertyReader.getProperty(
                    "qase.api.defect.getAllDefects.first_defect.id")))
                .title(PropertyReader.getProperty(
                    "qase.api.defect.getAllDefects.first_defect.title"))
                .actual_result(PropertyReader.getProperty(
                    "qase.api.defect.getAllDefects.first_defect.actual_result"))
                .milestone_id(Integer.parseInt(PropertyReader.getProperty(
                    "qase.api.all.milestone_id")))
                .project_id(Integer.parseInt(PropertyReader.getProperty(
                    "qase.api.all.project_id")))
                .member_id(Integer.parseInt(PropertyReader.getProperty(
                    "qase.api.defect.all.member_id")))
                .severity(PropertyReader.getProperty(
                    "qase_api.defect.getAllDefects.first_defect.severity"))
                .status(PropertyReader.getProperty(
                    "qase_api.defect.getAllDefects.first_defect.status"))
                .created(PropertyReader.getProperty(
                    "qase.api.defect.getAllDefects.first_defect.created"))
                .updated(PropertyReader.getProperty(
                    "qase.api.defect.getAllDefects.first_defect.updated"))
                .created_at(PropertyReader.getProperty(
                    "qase.api.defect.getAllDefects.first_defect.created_at"))
                .updated_at(PropertyReader.getProperty(
                    "qase.api.defect.getAllDefects.first_defect.updated_at"))
                .tags(List.of(Tag.builder()
                    .internal_id(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.all.tag.internal_id")))
                    .title(PropertyReader.getProperty("qase.api.all.tag.title"))
                    .build()))
                .attachments(new ArrayList<>())
                .custom_fields(new ArrayList<>())
                .external_data("{}")
                .build();
        }

    public static Defect getSecondDefectInfo() {
        return Defect.builder()
            .id(Integer.parseInt(PropertyReader.getProperty(
                "qase.api.defect.getAllDefects.second_defect.id")))
            .title(PropertyReader.getProperty(
                "qase.api.defect.getAllDefects.second_defect.title"))
            .actual_result(PropertyReader.getProperty(
                "qase.api.defect.getAllDefects.second_defect.actual_result"))
            .project_id(Integer.parseInt(PropertyReader.getProperty(
                "qase.api.all.project_id")))
            .member_id(Integer.parseInt(PropertyReader.getProperty(
                "qase.api.defect.all.member_id")))
            .severity(PropertyReader.getProperty(
                "qase_api.defect.getAllDefects.second_defect.severity"))
            .status(PropertyReader.getProperty(
                "qase_api.defect.getAllDefects.second_defect.status"))
            .created(PropertyReader.getProperty(
                "qase.api.defect.getAllDefects.second_defect.created"))
            .updated(PropertyReader.getProperty(
                "qase.api.defect.getAllDefects.second_defect.updated"))
            .created_at(PropertyReader.getProperty(
                "qase.api.defect.getAllDefects.second_defect.created_at"))
            .updated_at(PropertyReader.getProperty(
                "qase.api.defect.getAllDefects.second_defect.updated_at"))
            .attachments(new ArrayList<>())
            .custom_fields(new ArrayList<>())
            .tags(new ArrayList<>())
            .external_data("{}")
            .build();
        }
    }
