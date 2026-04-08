package com.sri.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="Caller_tune_info")
@RequiredArgsConstructor
@NoArgsConstructor
public class CallerTuneInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer tuneId;
	@NonNull
	private String tuneName;
	@NonNull
	private String movieName;
	@Column(name="UPDATE_COUNT")
	@Version
	private Integer updatedCount;
	@Column(name="SERVICE_OPTED_ON",insertable=true)
	@CreationTimestamp
	private LocalDateTime serviceOptedOn;
	@Column(name="LASTLY_UPDATED_ON",insertable=false)
	@UpdateTimestamp
	private LocalDateTime lastlyUpdatedOn;
}
