package fakhredinne.king_chapati.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
public class AdminController {

}
