package com.pandeyvivek007.job_app.controller;

import com.pandeyvivek007.job_app.entity.Job;
import com.pandeyvivek007.job_app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/job")
    public ResponseEntity<Job> saveJob(@RequestBody Job job) {
        Job savedJob = jobService.saveJob(job);
        return ResponseEntity.ok(savedJob);
    }

    @GetMapping("/job")
    public ResponseEntity<List<Job>> getAllJob() {
        return ResponseEntity.ok(jobService.getAllJob());
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/job")
    public ResponseEntity<Void> deleteAllJobs() {
        jobService.deleteAllJobs();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        return job != null ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }
}
