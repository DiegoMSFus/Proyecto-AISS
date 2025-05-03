package aiss.GitMiner.controller;

import aiss.GitMiner.model.Project;
import aiss.GitMiner.repository.ProjectRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gitminer/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public List<Project> getAllProjects() {return projectRepository.findAll();}

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Project create(@Valid @RequestBody Project project) {
        Project newProject = projectRepository.save(new Project(project.getName(), project.getWebUrl(), project.getCommits(), project.getIssues()));
        return newProject;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Project update(@Valid @RequestBody Project project, @PathVariable long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);

        Project _project = projectOptional.get();
        _project.setName(project.getName());
        _project.setWebUrl(project.getWebUrl());
        _project.setCommits(project.getCommits());
        _project.setIssues(project.getIssues());
        return projectRepository.save(_project);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        }
    }

}
