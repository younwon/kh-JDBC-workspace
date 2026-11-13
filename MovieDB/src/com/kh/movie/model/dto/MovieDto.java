package com.kh.movie.model.dto;

import java.sql.Date;

public class MovieDto {
	private Long movieId;
	private String movieName;
	private Date releaseDate;
	private Integer runningTime;
	private String movieRating;
	public MovieDto() {
		super();
	}
	public MovieDto(String movieName, Date releaseDate, Integer runningTime, String movieRating) {
		super();
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.runningTime = runningTime;
		this.movieRating = movieRating;
	}
	public MovieDto(Long movieId, String movieName, Date releaseDate, Integer runningTime, String movieRating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.runningTime = runningTime;
		this.movieRating = movieRating;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(Integer runningTime) {
		this.runningTime = runningTime;
	}
	public String getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}
	@Override
	public String toString() {
		return "MovieDto [movieId=" + movieId + ", movieName=" + movieName + ", releaseDate=" + releaseDate
				+ ", runningTime=" + runningTime + ", movieRating=" + movieRating + "]";
	}

	
	
	
}


