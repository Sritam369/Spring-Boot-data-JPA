package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

    public List<JobSeeker> findByJsaddrsEquals(String addrs);

    public List<JobSeeker> readByJsaddrsIs(String addrs);

    public List<JobSeeker> getByJsaddrs(String addrs);

    public List<JobSeeker> findByExpectedSalaryBetween(double start, double end);

    public List<JobSeeker> findByExpectedSalaryGreaterThanEqualAndExpectedSalaryLessThanEqual(double start, double end);

    public List<JobSeeker> findByJsaddrsInOrderByJsaddrsDesc(List<String> cities);

    public List<JobSeeker> findByJsnameStartingWith(String initChars);

    public List<JobSeeker> findByJsnameEndingWith(String lastChars);

    public List<JobSeeker> findByJsnameContaining(String chars);

    public List<JobSeeker> findByJsnameEqualsIgnoreCase(String name);

    public List<JobSeeker> findByJsaddrsLikeAndQlfyIn(String chars, List<String> qualifications);

    public List<JobSeeker> findByJsaddrsNotInOrQlfyNotLike(List<String> notAddrsList, String notQlfy);
}
