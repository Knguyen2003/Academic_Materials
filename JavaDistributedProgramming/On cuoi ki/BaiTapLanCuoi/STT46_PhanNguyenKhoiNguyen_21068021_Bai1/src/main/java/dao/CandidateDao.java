package dao;

import entity.Candidate;
import entity.Certificate;

import javax.swing.text.Position;
import java.util.Map;
import java.util.Set;

public interface CandidateDao {
    public Map<Candidate, Long> listCadidatesByCompanies();
    public Map<Candidate, Position> listCandidatesWithLongestWorking ();
    public boolean addCandidate(Candidate candidate);
    public Map<Candidate, Set<Certificate>> listCadidatesAndCertificates();
    public boolean deleteCandidate(String id);
    public Candidate tim();
}
