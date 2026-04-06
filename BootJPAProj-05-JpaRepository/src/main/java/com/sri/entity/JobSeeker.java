package com.sri.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name="jpa_js_tab")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public final class JobSeeker {
    @Column(name = "JS_ID")
    @Id
    @SequenceGenerator(name = "gen1",sequenceName = "JSID_SEQUENCE1",initialValue = 1000,allocationSize = 1)
    @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
    private Integer jsid;

    @NonNull
    @Column(length = 30, name = "JS_NAME")
    private String jsname;

    @NonNull
    @Column(length = 30, name = "JS_ADDRS")
    private String jsaddrs;

    @NonNull
    @Column(length = 30, name = "JS_QLFY")
    // @Transient
    private String qlfy;

    @NonNull
    @Column(name = "JS_EXP_SALARY")
    private Float expectedSalary;

    @NonNull
    @Column(name = "JS_EMAIL")
    private String email;

    @NonNull
    @Column(name = "JS_LOCATION")
    private String location;
}
