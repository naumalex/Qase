package utils;

import models.project.Counts;
import models.project.Defects;
import models.project.Project;
import models.project.Runs;


public class ProjectFactory {
        public static Project getFirstProjectInfo() {
            return Project.builder()
                .code(PropertyReader.getProperty(
                    "qase.api.project.getAllProjects.first_project.code"))
                .title(PropertyReader.getProperty(
                    "qase.api.project.getAllProjects.first_project.title"))
                .counts(Counts.builder()
                    .cases(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getAllProjects.first_project.counts_cases")))
                    .suites(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getAllProjects.first_project.counts_suits")))
                    .milestones(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getAllProjects.first_project.counts_milestones")))
                    .runs(Runs.builder().build())
                    .defects(Defects.builder().build())
                    .build())
                .build();
        }

    public static Project getSecondProjectInfo() {
        return Project.builder()
            .code(PropertyReader.getProperty(
                "qase.api.project.getAllProjects.second_project.code"
            ))
            .title(PropertyReader.getProperty(
                "qase.api.project.getAllProjects.second_project.title"))

            .counts(Counts.builder()
                .cases(Integer.parseInt(PropertyReader.getProperty(
                    "qase.api.project.getAllProjects.second_project.counts_cases")))
                .suites(Integer.parseInt(PropertyReader.getProperty(
                    "qase.api.project.getAllProjects.second_project.counts_suits")))
                .runs(Runs.builder().build())
                .defects(Defects.builder()
                    .total(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getAllProjects.second_project.counts_defects_total")))
                    .open(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getAllProjects.second_project.counts_defects_open")))
                    .build())
                .build())
            .build();
        }
    }
